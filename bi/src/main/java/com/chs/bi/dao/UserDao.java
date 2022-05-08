package com.chs.bi.dao;

import com.chs.bi.base.response.EasyPage;
import com.chs.bi.model.entity.User;
import com.chs.bi.model.vo.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public EasyPage<User> selectPage(UserQuery userQuery){

        Query query = Query.query(Criteria.where("name").is("chs"));

        long totalCount = mongoTemplate.count(query, User.class);

        List<User> list = mongoTemplate.find(query, User.class);

        EasyPage res = new EasyPage(list,totalCount);


        return res;
    }

}
