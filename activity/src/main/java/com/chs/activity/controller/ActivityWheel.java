package com.chs.activity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 20:16
 */
@RestController
public class ActivityWheel {

//    @Resource
//    StringRedisTemplate stringRedisTemplate;




    @GetMapping("/wheel")
    public String wheel() {

        String key = "chs:aa";



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
