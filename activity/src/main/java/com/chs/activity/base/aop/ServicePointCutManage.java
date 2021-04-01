package com.chs.activity.base.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class ServicePointCutManage {
    /**
     * 记录日志切点
     * 匹配impl包及任何子包下的后缀为Impl类型中的所有方法;
     */
    @Pointcut("execution(* com.chs.activity.controller.*Controller.*(..))")
    public void logService() {
    }

}
