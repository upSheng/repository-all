package com.chs.activity.repository;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface IOrderRepository {


    EasyPage<OrderEntity> list(OrderQuery orderQuery);

    List<OrderEntity> findAll();

    OrderEntity findById(String id);

    OrderEntity findByTransactionId(String transactionId);

    OrderEntity findByPayJsOrderId(String payJsOrderId);

    OrderEntity save(OrderEntity entity);

    void deleteById(String id);


}
