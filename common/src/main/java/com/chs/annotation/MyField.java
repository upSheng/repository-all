package com.chs.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解使用的范围， 属性上
@Target(value = {ElementType.FIELD})

//注解存在的时间 运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {

    String name();
    int length();
}
