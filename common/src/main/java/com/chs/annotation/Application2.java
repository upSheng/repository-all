package com.chs.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射：运行时可以改变程序结构和变量
 *
 * 一个类对应一个class变量
 */
public class Application2 {
    public static void main(String[] args) {

        String path = "com.chs.annotation.Student";
        try {
            Class clazz = Class.forName(path);

            //获取无参构造器
            Constructor constructor = clazz.getConstructor(null);
            Student student = (Student) constructor.newInstance();

            System.out.println(student);

            //获取属性
            Field name = clazz.getDeclaredField("name");

            name.setAccessible(true);  //去除安全检验
            name.set(student,"zhangsan");
            System.out.println(student.getName());

            //获取方法
            Method setName = clazz.getDeclaredMethod("setName", String.class);
            setName.invoke(student,"lisi");
            System.out.println(student.getName());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
