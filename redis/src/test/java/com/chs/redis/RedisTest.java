package com.chs.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
    private StringRedisTemplate template;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void  test1(){

        template.opsForValue().set("name","6666");

        redisTemplate.boundValueOps("age").set("15");

        User user = new User();
        user.setAge(11);
        user.setName("hoh");

        redisTemplate.boundValueOps("user").set(user);
        System.out.println(template);

    }

    @Test
    public void  test2(){

        String name = template.opsForValue().get("name");
        String age = (String) redisTemplate.boundValueOps("age").get();
        User user = (User) redisTemplate.boundValueOps("user").get();
        System.out.println(name);
        System.out.println(age);
        System.out.println("11"+user.getName());
        System.out.println("11"+user.getAge());

    }

    @Test
    public void test3(){
        redisTemplate.opsForValue().set("name","zhangsan",60, TimeUnit.SECONDS);

        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void test4(){
        String taskCode = "task001";
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(taskCode,"zhangsan",20, TimeUnit.SECONDS);

        if(flag != null && flag){

            System.out.println("1111");
        }

    }


    @Test
    public void test5(){

        for(int i=0;i<100;i++){
            redisTemplate.opsForZSet().add("activityId","chs"+i,i);

            if(redisTemplate.opsForZSet().size("activityId")>10+20){
                redisTemplate.opsForZSet().removeRange("activityId",0,20);
            }
        }

        Set result = redisTemplate.opsForZSet().reverseRange("activityId",0,0);

        System.out.println(redisTemplate.opsForZSet().size("activityId"));


        result.forEach((x)-> System.out.println(x));



    }
}