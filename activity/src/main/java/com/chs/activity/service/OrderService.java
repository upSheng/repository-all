package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chs.activity.base.exception.BusinessException;
import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.Constans;
import com.chs.activity.dao.OrderMapper;
import com.chs.activity.dao.GameMapper;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.modal.entity.GameEntity;
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
    OrderMapper orderMapper;


    @Value("${payjs.mchid}")
    private String mchid;

    @Value("${payjs.key}")
    private String key;

    @Value("${payjs.url}")
    private String url;

    @Value("${payjs.notifyUrl}")
    private String notifyUrl;

    public OrderEntity placeOrder(Integer gameId, String phone) {

        if (StringUtils.isEmpty(gameId) || StringUtils.isEmpty(phone)){
            throw new IllegalArgumentException("placeOrder param err");
        }

        GameEntity gameEntity = gameMapper.findById(gameId);
        if (gameEntity == null) {
            throw BusinessException.of("游戏不存在");
        }

        Random random = new Random();
        String code = String.format("%s%05d", "HS", random.nextInt(9999));
        String orderId = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()) + code;

        Map<String, String> payData = new TreeMap<>();
        payData.put("mchid", mchid);
        payData.put("total_fee", String.valueOf(gameEntity.getPrice()));
        payData.put("out_trade_no", orderId);
        payData.put("body", gameEntity.getName());
        payData.put("notify_url", notifyUrl);
        // 进行sign签名
        payData.put("sign", SignUtils.sign(payData,key));

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
                    .gameName(gameEntity.getName())
                    .gameId(gameId)
                    .phone(phone)
                    .totalFee(gameEntity.getPrice())
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

    public void payHandle(Map<String, String> params) {

        params = new TreeMap<>(params);
        log.info(JSON.toJSONString(params));
        String sign = params.get("sign");
        params.remove("sign");
        String signData = SignUtils.sign(params,key);
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
}
