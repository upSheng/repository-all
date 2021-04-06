package com.chs.activity.repository.impl;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.Constans;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.bean.OrderQuery;
import com.chs.activity.modal.entity.OrderEntity;
import com.chs.activity.repository.IOrderRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 11:10
 */
@Repository
public class OrderRepositoryImpl implements IOrderRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public EasyPage<OrderEntity> list(OrderQuery orderQuery) {

        Integer pageSize = orderQuery.getPageSize() == null ? Constans.DEFAULT_PAGESIZE : orderQuery.getPageSize();
        Integer pageNum = orderQuery.getPageNum() == null ? Constans.DEFAULT_PAGENUM : orderQuery.getPageNum();
        String productName = orderQuery.getProductName();
        Query query = new Query();


        if (!StringUtils.isEmpty(productName)) {
            Pattern pattern = Pattern.compile("^.*" + productName + ".*", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where(MongoConstants.PRODUCT_NAME).regex(pattern));
        }

        if (!StringUtils.isEmpty(orderQuery.getId())) {
            query.addCriteria(Criteria.where(MongoConstants.OUT_TRADE_NO).is(orderQuery.getId()));
        }

        if (!StringUtils.isEmpty(orderQuery.getTransactionId())) {
            query.addCriteria(Criteria.where(MongoConstants.TRANSACTION_ID).is(orderQuery.getTransactionId()));
        }

        long count = mongoTemplate.count(query, OrderEntity.class);
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        List<OrderEntity> orderEntityList = mongoTemplate.find(query, OrderEntity.class);
        return new EasyPage<>(orderEntityList, count);


    }

    @Override
    public List<OrderEntity> findAll() {
        return mongoTemplate.findAll(OrderEntity.class);
    }

    @Override
    public OrderEntity findById(String id) {
        return mongoTemplate.findById(id, OrderEntity.class);
    }

    @Override
    public OrderEntity findByTransactionId(String transactionId) {
        return mongoTemplate.findOne(Query.query(Criteria.where(MongoConstants.TRANSACTION_ID).is(transactionId)), OrderEntity.class);
    }

    @Override
    public List<OrderEntity> findByTransactionIdList(List<String> transactionIdList) {
        return mongoTemplate.find(Query.query(Criteria.where(MongoConstants.TRANSACTION_ID).in(transactionIdList)), OrderEntity.class);
    }

    @Override
    public OrderEntity findByPayJsOrderId(String payJsOrderId) {
        return mongoTemplate.findOne(Query.query(Criteria.where(MongoConstants.PAY_JS_ORDER_ID).is(payJsOrderId)), OrderEntity.class);
    }

    @Override
    public OrderEntity save(OrderEntity entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public void deleteById(String id) {

        mongoTemplate.remove(Query.query(Criteria.where(MongoConstants.ID).is(id)), OrderEntity.class);
    }
}
