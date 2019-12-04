package com.chs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解
 */
public class Application {

    public static void main(String[] args) {

        try {

            //加载类
            Class clazz = Class.forName("com.chs.annotation.Student");

            //获取类上的注解
            Annotation[] annotations = clazz.getAnnotations();

            for (Annotation annotation : annotations) {
                System.out.println(annotation);

            }
            //获取类注解的值
            MyTable myTable = (MyTable) clazz.getAnnotation(MyTable.class);
            System.out.println(myTable.value());

            //获取属性注解的值

            Field f = clazz.getDeclaredField("name");

            MyField myField = f.getAnnotation(MyField.class);
            System.out.println(myField.name() + "  " + myField.length());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
