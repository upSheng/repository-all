package com.chs.redis;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/12<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/12            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RedisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test1() {

        String key = "name";
        String value = "chs";
        stringRedisTemplate.opsForValue().set(key, value, 60, TimeUnit.SECONDS);
        String name = stringRedisTemplate.opsForValue().get("name");

    }


    @Test
    public void test2() {

        String key = "activity:chs";
        for (int i = 0; i < 100; i++) {
            User user = new User("chs", i, new Date());
            JSON.toJSONString(user);
            stringRedisTemplate.opsForList().leftPush(key, JSON.toJSONString(user));
        }
        List<String> range = stringRedisTemplate.opsForList().range(key, 0, 50);
        assert range != null;
        List<User> collect = range.stream().map(x -> JSON.parseObject(x, User.class)).collect(Collectors.toList());

        //保留0-50 个
        stringRedisTemplate.opsForList().trim(key, 0, 50);
    }

    /**
     * hash 结构
     */
    @Test
    public void test3(){
        String key = "user";
        redisTemplate.opsForHash().put(key,"name","chs");
        redisTemplate.opsForHash().put(key,"age",14);
        Object age = redisTemplate.opsForHash().get(key, "age");

        System.out.println(age);

    }
    /**
     * 非阻塞取值
     */
    @Test
    public void test4() {

        Set<String> keys = new HashSet<>();
        ScanOptions options = ScanOptions.scanOptions().match("activity*").count(10).build();
        stringRedisTemplate.execute(connect -> {
            Cursor<byte[]> cursor = connect.scan(options);
            while (cursor.hasNext()){
                byte[] key = cursor.next();
                keys.add(new String(key));
            }
            return true;
        }, true);

        System.out.println(keys);
    }

}