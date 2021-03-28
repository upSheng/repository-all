package com.chs.activity.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chs.activity.base.exception.BusinessException;
import com.chs.activity.config.Constans;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.utils.HttpUtils;
import com.chs.activity.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/23 9:56
 */
@Slf4j
@Service
public class PlaceOrderService {

    @Resource
    MongoTemplate mongoTemplate;

    public OrderEntity placeOrder(String id) {

        ProductEntity productEntity = mongoTemplate.findById(id, ProductEntity.class);
        if (productEntity == null) {
            throw new BusinessException("商品不存在");
        }

        Random random = new Random();
        String code = String.format("%s%05d", "HS", random.nextInt(9999));
        String outTradeNo = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()) + code;

        Map<String, String> payData = new TreeMap<>();
        payData.put("mchid", Constans.MCHID);
        payData.put("total_fee", String.valueOf(productEntity.getPrice()));
        payData.put("out_trade_no", outTradeNo);
        payData.put("body", productEntity.getName());
        payData.put("notify_url", Constans.NOTIFY_URL);
        // 进行sign签名
        payData.put("sign", SignUtils.sign(payData));

        String res;
        try {
            log.info("placeOrderReq===>{} ", JSON.toJSONString(payData));
            res = HttpUtils.sendPost(Constans.URL, payData);
            log.info("placeOrderRes===>{} ", res);
        } catch (Exception ex) {
            log.error("请求失败");
            throw new BusinessException(ex.getMessage());
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
            mongoTemplate.save(order);
            return order;
        } else {
            log.error("订单创建失败");
            throw new BusinessException("订单创建失败");
        }

    }

    public void payHandle(Map<String, String> params) {

        params = new TreeMap<>(params);
        log.info(JSON.toJSONString(params));
        String sign = params.get("sign");
        params.remove("sign");
        String signData = SignUtils.sign(params);
        if (sign.equals(signData)) {

            String payJsOrderId = params.get("payjs_order_id");
            OrderEntity order = mongoTemplate.findOne(Query.query(Criteria.where(MongoConstants.PAY_JS_ORDER_ID).is(payJsOrderId)), OrderEntity.class);
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

//            Query query = Query.query(Criteria.where(MongoConstants.OUT_TRADE_NO).is(order.getOutTradeNo()));
//            Update update = new Update();
//            update.set(MongoConstants.TRANSACTION_ID, transactionId);
//            update.set(MongoConstants.STATUS, Constans.ORDER_STATUS_SUCCESS);
//            update.set(MongoConstants.TIME_END, timeEnd);
//            update.set(MongoConstants.UPDATE_TIME, LocalDateTime.now());
//            mongoTemplate.upsert(query, update, OrderEntity.class);
            mongoTemplate.save(order);

        } else {
            log.error("sign err");
        }

    }


    public OrderEntity findOrder(String id) {

        Criteria criteria = new Criteria()
                .orOperator(Criteria.where(MongoConstants.OUT_TRADE_NO).is(id), Criteria.where(MongoConstants.TRANSACTION_ID).is(id));

        return mongoTemplate.findOne(Query.query(criteria), OrderEntity.class);
    }


}
