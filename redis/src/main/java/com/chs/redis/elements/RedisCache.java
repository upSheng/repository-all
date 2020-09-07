package com.chs.redis.elements;

import com.alibaba.fastjson.JSONObject;
import com.chs.redis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : HongSheng.Chen
 * @date : 2020/8/16 10:19
 */
@Component
public class RedisCache {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    final Long tenMinute = 10 * 60 * 1000L;


    public List<User> userListCache() {
        String key = KeyConfig.splitWithColon("a");
        String value = redisTemplate.opsForValue().get(key);

        if (value == null) {
            List<User> result = userList();
            value = JSONObject.toJSONString(result);
            redisTemplate.opsForValue().set(key, value, tenMinute, TimeUnit.MILLISECONDS);
            return result;
        }
        return JSONObject.parseArray(value, User.class);
    }

    private List<User> userList() {

        User user1 = new User("chs", 13, new Date());
        User user2 = new User("chs", 13, new Date());
        List<User> result = new ArrayList<>();
        result.add(user1);
        result.add(user2);
        return result;

    }

    public void refresh() {
        String userKey = KeyConfig.splitWithColon("a");
        List<User> userList = userList();
        String userValue = JSONObject.toJSONString(userList);
        redisTemplate.opsForValue().set(userKey, userValue, tenMinute, TimeUnit.MILLISECONDS);

    }




}
