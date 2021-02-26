package com.chs.activity.service;

import com.chs.activity.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/26 16:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
class FundServiceTest {

    @Resource
    FundService fundService;

    @Test
    void saveNetWorthTrendList() {

        //005827
        //100022
        fundService.saveNetWorthTrendList("100022");
    }
}