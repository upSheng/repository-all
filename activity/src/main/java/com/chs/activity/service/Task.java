package com.chs.activity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/3 15:40
 */
@Slf4j
@Component
@EnableScheduling
public class Task {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    private void taskTest() {
        log.info("task");
    }

    public void redisTest() {
        stringRedisTemplate.opsForValue().set("name", "张三");
        log.info(stringRedisTemplate.opsForValue().get("name"));
    }
}
