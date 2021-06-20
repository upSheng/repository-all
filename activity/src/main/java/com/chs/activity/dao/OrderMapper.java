package com.chs.activity.dao;

import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:34
 */
public interface OrderMapper {


    List<OrderEntity> list(OrderQuery orderQuery);

    void insert(OrderEntity entity);

    @Select("select * from `order` where order_id = #{orderId}")
    OrderEntity findByOrderId(String orderId);

    void update(OrderEntity entity);
}
