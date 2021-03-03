package com.chs.activity.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class ServiceAopManage {


    @Around("com.chs.activity.aop.ServicePointCutManage.logService()")
    public Object methodHandle(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] objects = proceedingJoinPoint.getArgs();
        String className = proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object request = null;
        try {

            //输入日志
            log.info("[{}][{}]Start to handle request:[{}]", className, methodName, objects);
            long s = System.currentTimeMillis();
            Object response = proceedingJoinPoint.proceed();
            log.debug("[{}][{}]Finish handling request ,elapsed time:{}ms",
                    className, methodName, (System.currentTimeMillis() - s));
            return response;
        } catch (Throwable e) {
            log.error("[{}][{}][{}]handling exception message is :", className, methodName, objects, e);

        }

        return null;
    }
}
