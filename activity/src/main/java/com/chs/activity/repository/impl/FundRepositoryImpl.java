package com.chs.activity.repository.impl;

import com.chs.activity.modal.entity.FundEntity;
import com.chs.activity.repository.IFundRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/28 15:51
 */
@Repository
public class FundRepositoryImpl implements IFundRepository {

    @Resource
    MongoTemplate mongoTemplate;


    @Override
    public List<FundEntity> saveAll(List<FundEntity> fundEntityList) {

        return (List<FundEntity>) mongoTemplate.insert(fundEntityList, FundEntity.class);
    }

    @Override
    public FundEntity findByCode(String code) {

        Query query = new Query(Criteria.where("code").is(code));
        return mongoTemplate.findOne(query, FundEntity.class);
    }
}
