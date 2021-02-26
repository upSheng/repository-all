package com.chs.activity.repository.impl;

import com.chs.activity.base.response.EasyPage;
import com.chs.activity.config.MongoConstants;
import com.chs.activity.modal.entity.PersonEntity;
import com.chs.activity.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/18 14:38
 */
@Service
public class PersonRepositoryImpl implements IPersonRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public EasyPage<PersonEntity> page(Integer pageNum, Integer pageSize, String name) {

        Query query = new Query();
        query.skip((pageNum - 1) * pageSize).limit(pageSize);

        if (!StringUtils.isEmpty(name)) {
            Pattern pattern = Pattern.compile("^.*" + name + ".*", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where(MongoConstants.NAME).regex(pattern));
        }

        long count = mongoTemplate.count(query, PersonEntity.class);
        List<PersonEntity> personEntities = mongoTemplate.find(query, PersonEntity.class);
        return new EasyPage<>(personEntities, count);
    }

    @Override
    public PersonEntity findById(String id) {
        return mongoTemplate.findById(id, PersonEntity.class);
    }

    @Override
    public PersonEntity save(PersonEntity person) {
        return mongoTemplate.save(person);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(Query.query(Criteria.where(MongoConstants.ID).is(id)), PersonEntity.class);
    }


}
