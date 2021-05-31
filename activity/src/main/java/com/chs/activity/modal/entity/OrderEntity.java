package com.chs.activity.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/23 10:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class OrderEntity {


    private String id;

    /**
     * 用户端自主生成的订单号
     */
    private String outTradeNo;

    /**
     * 平台订单号
     */
    private String payJsOrderId;

    /**
     * 交易号
     */
    private String transactionId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 用户
     */
    private String userId;


    /**
     * 金额
     */
    private Integer totalFee;


    /**
     * 状态
     */
    private Integer status;

    /**
     * 二维码图片
     */
    private String qrCode;

    /**
     * 支付时间
     */
    private String timeEnd;


    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
