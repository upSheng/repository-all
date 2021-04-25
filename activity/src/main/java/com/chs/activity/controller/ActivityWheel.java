package com.chs.activity.controller;


import com.chs.activity.modal.entity.ProductEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 20:16
 */
@RestController
public class ActivityWheel {

//    @Resource
//    StringRedisTemplate stringRedisTemplate;

    @Resource
    private MongoTemplate mongoTemplate;


    @GetMapping("/wheel")
    public String wheel() {

        String key = "chs:aa";

        ProductEntity productEntity = mongoTemplate.findById("60656765c978334d1e8ba94f",ProductEntity.class);
        productEntity.setName("111");
        productEntity.setDescribe(null);
        mongoTemplate.save(productEntity);

//        stringRedisTemplate.opsForValue().set(key, "1");
//
//        stringRedisTemplate.expire(key, 50 * 1000L, TimeUnit.MILLISECONDS);
//        stringRedisTemplate.opsForValue().set(key, "22");
//
//        stringRedisTemplate.expire(key, 50 * 1000L, TimeUnit.MILLISECONDS);
//
//        stringRedisTemplate.expire(key, -10000L, TimeUnit.MILLISECONDS);
        Random random = new Random();
        return String.valueOf(random.nextInt(10));
    }
}
