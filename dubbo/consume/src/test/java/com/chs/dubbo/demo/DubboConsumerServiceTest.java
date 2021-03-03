package com.chs.dubbo.demo;

import com.chs.dubbo.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/3 14:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
class DubboConsumerServiceTest {


    @Resource
    DubboConsumerService dubboConsumerService;

    @Test
    void say() {
        dubboConsumerService.say();
    }
}