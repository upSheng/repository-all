package com.chs.activity.repository.impl;

import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.entity.UserEntity;
import com.chs.activity.repository.IUserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/4/1 16:19
 */
@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public UserEntity findByName(String name) {
        return mongoTemplate.findOne(Query.query(Criteria.where(MongoConstants.NAME).is(name)), UserEntity.class);
    }

    @Override
    public UserEntity findById(String id) {
        return mongoTemplate.findById(id, UserEntity.class);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return mongoTemplate.save(entity);
    }
}
