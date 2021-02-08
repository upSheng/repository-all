package com.chs.activity.aop;


import com.chs.activity.annotation.LogPoint;
import org.springframework.stereotype.Component;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/23 19:47
 */
@Component
public class Cat {

    @LogPoint
    public void say(String name) {
        System.out.println(name);
    }
}
