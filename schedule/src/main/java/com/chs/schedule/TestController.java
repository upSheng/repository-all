package com.chs.schedule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/set")
    public String set(HttpServletRequest request){

        String key = request.getParameter("key");
        String value = request.getParameter("value");
        redisTemplate.opsForValue().set(key,value,60, TimeUnit.SECONDS);

        return "ok";
    }

    @RequestMapping("/get")
    public String get(HttpServletRequest request){
        String key = request.getParameter("key");
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }
}
