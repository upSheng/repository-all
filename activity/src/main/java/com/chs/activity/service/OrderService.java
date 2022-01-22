package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chs.activity.base.exception.BusinessException;
import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.Constans;
import com.chs.activity.dao.GameListMapper;
import com.chs.activity.dao.GameMapper;
import com.chs.activity.dao.GameUserMapper;
import com.chs.activity.dao.OrderMapper;
import com.chs.activity.modal.bean.OrderParam;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.GameEntity;
import com.chs.activity.modal.entity.GameListEntity;
import com.chs.activity.modal.entity.GameUserEntity;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.utils.HttpUtils;
import com.chs.activity.utils.SignUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/23 9:56
 */
@Slf4j
@Service
public class OrderService {

    @Resource
    GameMapper gameMapper;

    @Resource
    GameUserMapper gameUserMapper;

    @Resource
    GameListMapper gameListMapper;


    @Resource
    OrderMapper orderMapper;


    @Value("${payjs.mchid}")
    private String mchid;

    @Value("${payjs.key}")
    private String key;

    @Value("${payjs.url}")
    private String url;

    @Value("${payjs.notifyUrl}")
    private String notifyUrl;

    public OrderEntity placeOrder(OrderParam orderParam) {

        Integer type = orderParam.getType();
        String phone = orderParam.getPhone();
        Integer productId = orderParam.getProductId();

        if (StringUtils.isEmpty(phone) || type == null || productId == null) {
            throw new IllegalArgumentException("placeOrder param err");
        }

        if (type == 1) {

            GameEntity gameEntity = gameMapper.findById(productId);
            if (gameEntity == null) {
                throw BusinessException.of("游戏不存在");
            }

            Integer totalFee = gameEntity.getPrice();
            String productName = gameEntity.getName();
            return doOrder(type, productId, productName, totalFee, phone);
        }

        if (type == 2) {
            GameListEntity gameListEntity = gameListMapper.findById(productId);

            Integer totalFee = gameListEntity.getPrice();
            String productName = gameListEntity.getName();
            return doOrder(type, productId, productName, totalFee, phone);
        }
        if (type == 3) {
            Integer totalFee = productId == 1 ? 198 : 298;
            String productName = productId == 1 ? "会员" : "高级会员";
            return doOrder(type, productId, productName, totalFee, phone);
        }

        return null;

    }

    public void payHandle(Map<String, String> params) {

        params = new TreeMap<>(params);
        log.info(JSON.toJSONString(params));
        String sign = params.get("sign");
        params.remove("sign");
        String signData = SignUtils.sign(params, key);
        if (sign.equals(signData)) {

            String orderId = params.get("out_trade_no");
            OrderEntity order = orderMapper.findByOrderId(orderId);
            if (order == null) {
                log.error("无此订单{}", JSON.toJSONString(params));
                return;
            }
            String transactionId = params.get("transaction_id");
            String timeEnd = params.get("time_end");
            order.setTimeEnd(timeEnd);
            order.setTransactionId(transactionId);
            order.setStatus(Constans.ORDER_STATUS_SUCCESS);
            order.setUpdateTime(LocalDateTime.now());
            orderMapper.update(order);

            Integer type = order.getType();
            if (type == 1) {

                GameUserEntity gameUserEntity = gameUserMapper.findByOrderId(orderId);
                if (gameUserEntity == null) {
                    gameUserEntity = GameUserEntity.builder().gameId(order.getProductId())
                            .orderId(orderId)
                            .phone(order.getPhone())
                            .createTime(LocalDateTime.now())
                            .updateTime(LocalDateTime.now())
                            .build();
                    gameUserMapper.insert(gameUserEntity);
                }

            }

        } else {
            log.error("sign err");
        }

    }

    public OrderEntity findByOrderId(String orderId) {
        return orderMapper.findByOrderId(orderId);
    }

    public EasyPage<OrderEntity> list(OrderQuery orderQuery) {
        PageHelper.startPage(orderQuery.getPageNum(), orderQuery.getPageSize());
        List<OrderEntity> orderEntityList = orderMapper.list(orderQuery);
        PageInfo pageInfo = new PageInfo(orderEntityList);
        return new EasyPage<>(pageInfo.getList(), pageInfo.getTotal());
    }


    private OrderEntity doOrder(Integer type, Integer productId, String productName, Integer totalFee, String phone) {

        Random random = new Random();
        String code = String.format("%s%05d", "HS", random.nextInt(9999));
        String orderId = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()) + code;

        Map<String, String> payData = new TreeMap<>();
        payData.put("mchid", mchid);
        payData.put("total_fee", String.valueOf(totalFee));
        payData.put("out_trade_no", orderId);
        payData.put("body", productName);
        payData.put("notify_url", notifyUrl);
        // 进行sign签名
        payData.put("sign", SignUtils.sign(payData, key));

        String res;
        try {
            log.info("placeOrderReq===>{} ", JSON.toJSONString(payData));
            res = HttpUtils.post(url, payData);
            log.info("placeOrderRes===>{} ", res);
        } catch (Exception ex) {
            log.error("请求失败");
            throw BusinessException.of(ex.getMessage());
        }

        JSONObject resJson = JSON.parseObject(res);
        Integer returnCode = resJson.getInteger("return_code");
        if (returnCode == 1) {
            String payJsOrderId = resJson.getString("payjs_order_id");
            String qrCode = resJson.getString("qrcode");
            OrderEntity order = OrderEntity.builder()
                    .orderId(orderId)
                    .orderJsId(payJsOrderId)
                    .productName(productName)
                    .productId(productId)
                    .phone(phone)
                    .type(type)
                    .totalFee(totalFee)
                    .status(Constans.ORDER_STATUS_DEFAULT)
                    .qrCode(qrCode)
                    .createTime(LocalDateTime.now())
                    .build();
            orderMapper.insert(order);
            return order;
        } else {
            log.error("订单创建失败");
            throw BusinessException.of("订单创建失败");
        }

    }
}
