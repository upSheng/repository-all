package com.web.service.impl;

import com.web.Application;
import com.web.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void findMenuByUser() {

        UserEntity userEntity = new UserEntity();
        userEntity.setAge(11);
        userEntity.setName("chs");
        String password = "123456";
        userEntity.setPassword(new BCryptPasswordEncoder().encode(password));
        userEntity.setCreateTime(new Date());
        userEntity.setUpdateTime(new Date());
        userEntity.setCreateUser("admin");
        userEntity.setUpdateUser("admin");
        userService.save(userEntity);

        UserEntity userEntity1 = userService.findByName("chs");
        System.out.println(userEntity);
    }

}