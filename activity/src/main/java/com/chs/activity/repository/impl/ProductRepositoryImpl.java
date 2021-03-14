package com.chs.activity.repository.impl;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.repository.IProductRepository;
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
 * @date : 2021/2/18 14:38
 */
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public EasyPage<ProductEntity> page(Integer pageNum, Integer pageSize, String name) {

        Query query = new Query();
        query.skip((pageNum - 1) * pageSize).limit(pageSize);

        if (!StringUtils.isEmpty(name)) {
            Pattern pattern = Pattern.compile("^.*" + name + ".*", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where(MongoConstants.NAME).regex(pattern));
        }

        long count = mongoTemplate.count(query, ProductEntity.class);
        List<ProductEntity> personEntities = mongoTemplate.find(query, ProductEntity.class);
        return new EasyPage<>(personEntities, count);
    }

    @Override
    public ProductEntity findById(String id) {
        return mongoTemplate.findById(id, ProductEntity.class);
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(Query.query(Criteria.where(MongoConstants.ID).is(id)), ProductEntity.class);
    }

    @Override
    public List<ProductEntity> findAll() {
        return mongoTemplate.findAll(ProductEntity.class);
    }
}
