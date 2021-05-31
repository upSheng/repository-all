package com.chs.activity.repository.impl;

import com.alibaba.fastjson.JSON;
import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.Constans;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.bean.GameAccount;
import com.chs.activity.modal.bean.ProductQuery;
import com.chs.activity.modal.entity.ProductEntity;
import com.chs.activity.repository.IProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
    public EasyPage<ProductEntity> list(ProductQuery productQuery) {

        Integer pageSize = productQuery.getPageSize() == null ? Constans.DEFAULT_PAGESIZE : productQuery.getPageSize();
        Integer pageNum = productQuery.getPageNum() == null ? Constans.DEFAULT_PAGENUM : productQuery.getPageNum();
        String key = productQuery.getKeys();

        Query query = new Query();
        if (!StringUtils.isEmpty(key)) {
            Pattern pattern = Pattern.compile("^.*" + key + ".*", Pattern.CASE_INSENSITIVE);
            Criteria keyCriteria = new Criteria().orOperator(Criteria.where(MongoConstants.NAME).regex(pattern), Criteria.where(MongoConstants.KEY).regex(pattern));
            query.addCriteria(keyCriteria);
        }

        Integer label = productQuery.getLabel();
        if (label != null) {
            query.addCriteria(Criteria.where(MongoConstants.LABEL).is(label));
        }



        if (productQuery.getUserId() != null){
            if (productQuery.getOwn() != null && productQuery.getOwn() == 1 ){
                query.addCriteria(Criteria.where(MongoConstants.ID).in(productQuery.getProductIdSet()));
            }else {
                query.addCriteria(Criteria.where(MongoConstants.ID).nin(productQuery.getProductIdSet()));
            }
        }


        long count = mongoTemplate.count(query, ProductEntity.class);
        query.skip((pageNum - 1) * pageSize).limit(pageSize).with(Sort.by(Sort.Order.desc(MongoConstants.WEIGHT)));
        List<ProductEntity> personEntities = mongoTemplate.find(query, ProductEntity.class);
        return new EasyPage<>(personEntities, count);
    }

    @Override
    public ProductEntity findById(String id) {
        return mongoTemplate.findById(id, ProductEntity.class);
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        if (entity.getId() == null){
            entity.setCreateTime(LocalDateTime.now());
        }

        if (!StringUtils.isEmpty(entity.getGameAccountListJson())){
            List<GameAccount> gameAccountList = JSON.parseArray(entity.getGameAccountListJson(), GameAccount.class);
            entity.setGameAccountList(gameAccountList);
        }
        entity.setUpdateTime(LocalDateTime.now());
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
