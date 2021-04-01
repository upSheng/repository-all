package com.chs.activity.modal.bean;

import lombok.Data;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 11:02
 */
@Data
public class OrderQuery {

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

    private Integer pageNum;
    private Integer pageSize;
    private String productName;
}
