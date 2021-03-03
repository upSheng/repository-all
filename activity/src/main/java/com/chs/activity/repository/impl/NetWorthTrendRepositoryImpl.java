package com.chs.activity.repository.impl;

import com.chs.activity.modal.entity.NetWorthTrendEntity;
import com.chs.activity.repository.INetWorthTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:38
 */
@Repository
public class NetWorthTrendRepositoryImpl implements INetWorthTrendRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public NetWorthTrendEntity save(NetWorthTrendEntity netWorthTrendEntity, String collectionName) {
        return mongoTemplate.save(netWorthTrendEntity, collectionName);
    }

    @Override
    public List<NetWorthTrendEntity> saveAll(List<NetWorthTrendEntity> netWorthTrendEntityList, String collectionName) {
        return (List<NetWorthTrendEntity>) mongoTemplate.insert(netWorthTrendEntityList, collectionName);
    }

    @Override
    public List<NetWorthTrendEntity> findAll(String collectionName) {
        return mongoTemplate.findAll(NetWorthTrendEntity.class, collectionName);
    }
}
