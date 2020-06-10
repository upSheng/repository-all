package com.chs.note.registry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/13 19:56
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] names = app.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
    }
}
