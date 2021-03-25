package com.chs.activity.dao;

import com.chs.activity.Application;
import com.chs.activity.modal.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/3 15:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
class UserEntityMapperTest {

    @Resource
    UserMapper userEntityMapper;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {

        UserEntity userEntity = new UserEntity();
        userEntity.setAge(11).setCreateTime(LocalDateTime.now()).setName("zzz").setPassword("222");
        userEntityMapper.insert(userEntity);
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void selectAll() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}