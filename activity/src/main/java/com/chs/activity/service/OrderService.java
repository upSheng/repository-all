package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chs.activity.base.exception.BusinessException;
import com.chs.activity.base.exception.ExceptionEnum;
import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.Constans;
import com.chs.activity.modal.bean.OrderAward;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.repository.IOrderRepository;
import com.chs.activity.repository.IProductRepository;
import com.chs.activity.utils.HttpUtils;
import com.chs.activity.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/23 9:56
 */
@Slf4j
@Service
public class OrderService {

    @Resource
    IProductRepository productRepository;

    @Resource
    IOrderRepository orderRepository;


    @Value("${payjs.mchid}")
    private String mchid;

    @Value("${payjs.key}")
    private String key;

    @Value("${payjs.url}")
    private String url;

    @Value("${payjs.notifyUrl}")
    private String notifyUrl;

    public OrderEntity placeOrder(String id) {

        ProductEntity productEntity = productRepository.findById(id);
        if (productEntity == null) {
            throw BusinessException.of("商品不存在");
        }

        Random random = new Random();
        String code = String.format("%s%05d", "HS", random.nextInt(9999));
        String outTradeNo = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()) + code;

        Map<String, String> payData = new TreeMap<>();
        payData.put("mchid", mchid);
        payData.put("total_fee", String.valueOf(productEntity.getPrice()));
        payData.put("out_trade_no", outTradeNo);
        payData.put("body", productEntity.getName());
        payData.put("notify_url", notifyUrl);
        // 进行sign签名
        payData.put("sign", SignUtils.sign(payData,key));

        String res;
        try {
            log.info("placeOrderReq===>{} ", JSON.toJSONString(payData));
            res = HttpUtils.sendPost(url, payData);
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
                    .outTradeNo(outTradeNo)
                    .payJsOrderId(payJsOrderId)
                    .productName(productEntity.getName())
                    .productId(id)
                    .totalFee(productEntity.getPrice())
                    .status(Constans.ORDER_STATUS_DEFAULT)
                    .qrCode(qrCode)
                    .createTime(LocalDateTime.now())
                    .build();
            orderRepository.save(order);
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

            String payJsOrderId = params.get("payjs_order_id");
            OrderEntity order = orderRepository.findByPayJsOrderId(payJsOrderId);
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
            orderRepository.save(order);

        } else {
            log.error("sign err");
        }

    }

    public OrderEntity findOrderByPayJsOrderId(String payJsOrderId) {
        return orderRepository.findByPayJsOrderId(payJsOrderId);
    }


    public OrderAward findAward(String transactionId) {

        OrderEntity orderEntity = orderRepository.findByTransactionId(transactionId);

        if (orderEntity == null) {
            throw BusinessException.of(ExceptionEnum.REGISTER_ERR);
        }
        String productId = orderEntity.getProductId();
        ProductEntity productEntity = productRepository.findById(productId);
        return OrderAward.builder().createTime(orderEntity.getCreateTime())
                .transactionId(transactionId)
                .account(productEntity.getAccount())
                .name(orderEntity.getProductName())
                .password(productEntity.getPassword())
                .build();
    }

    public List<OrderAward> findAwardList(List<String> transactionIdList) {

        List<OrderEntity> orderEntityList = orderRepository.findByTransactionIdList(transactionIdList);

        if (CollectionUtils.isEmpty(orderEntityList)) {
            return Collections.emptyList();
        }

        List<OrderAward> res = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            String productId = orderEntity.getProductId();
            ProductEntity productEntity = productRepository.findById(productId);
            if (productEntity == null){
                continue;
            }
            OrderAward orderAward = OrderAward.builder().createTime(orderEntity.getCreateTime())
                    .transactionId(orderEntity.getTransactionId())
                    .account(productEntity.getAccount())
                    .name(orderEntity.getProductName())
                    .password(productEntity.getPassword())
                    .build();
            res.add(orderAward);
        }

        return res;
    }

    public EasyPage<OrderEntity> list(OrderQuery query) {
        return orderRepository.list(query);
    }


}
