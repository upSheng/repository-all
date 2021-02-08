package com.chs.activity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/23 19:36
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogPoint {
    String value() default "";

    boolean printReturn() default true;
}
