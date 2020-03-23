package com.chs.aop;

import com.chs.annotation.LogPoint;
import org.springframework.stereotype.Component;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/23 19:47
 */
@Component
public class Cat {

    @LogPoint
    public void say(String name){
        System.out.println(name);
    }
}
