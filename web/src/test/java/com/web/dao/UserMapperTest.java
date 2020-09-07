package com.web.dao;

import com.web.Application;
import com.web.entity.UserEntity;
import com.web.entity.query.UserEntityQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/23 9:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByQuery() {
        UserEntityQuery userEntityQuery = new UserEntityQuery();
        userEntityQuery.setStartTime("2018-01-01 00:00:00");
        userEntityQuery.setEndTime("2021-01-01 00:00:00");
        List<UserEntity> userEntityList = userMapper.findByQuery(userEntityQuery);
        System.out.println(userEntityList);
    }

    @Test
    public void insert(){

        UserEntity userEntity = new UserEntity();
        userEntity.setName("hah");
        userEntity.setCreateTime(new Date());
        userMapper.insert(userEntity);
        System.out.println(userEntity.getId());
    }

    @Test
    public void update(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(4);
        userEntity.setName("hah11");
        userEntity.setUpdateTime(new Date());
        userMapper.update(userEntity);
    }

    @Test
    public void delete(){

        userMapper.delete(3);


    }
}
