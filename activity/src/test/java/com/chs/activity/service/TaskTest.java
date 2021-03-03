package com.chs.activity.service;

import com.chs.activity.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/3 15:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
class TaskTest {

    @Resource
    Task task;

    @Test
    void redisTest() {
        task.redisTest();
    }
}