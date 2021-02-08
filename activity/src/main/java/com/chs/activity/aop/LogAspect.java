package com.chs.activity.aop;


import com.chs.activity.annotation.LogPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author : HongSheng.Chen
 * @date : 2020/3/23 19:38
 */

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.chs.activity.annotation.LogPoint)")
    public void log() {

    }

    @Around(value = "log() && @annotation(logPoint)")
    public Object around(ProceedingJoinPoint point, LogPoint logPoint) {

        System.out.println("tt");
        long start = System.currentTimeMillis();
        // 生成本次请求的串号
        String seriNo = UUID.randomUUID().toString().replace("-", "");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        String nodeInfo = logPoint.value();
        //      logger.info(nodeInfo + ": {} :---->", seriNo);
//        logger.info("\t{} : URL = ", seriNo, request.getRequestURL().toString());
//        logger.info("\t{} : HTTP_METHOD = {}", seriNo, request.getMethod());
//        logger.info("\t{} : IP = {}", seriNo, request.getRemoteAddr());
//        logger.info("\t{} : CLASS_METHOD = {}", seriNo, point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> keys = parameterMap.entrySet();
        Iterator<Map.Entry<String, String[]>> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String[]> next = iterator.next();
            //logger.info("\t{} : PARAM : {} = {}", seriNo, next.getKey(), Arrays.toString(next.getValue()));
        }
        try {
//            Signature signature =  point.getSignature();
//            Class returnType = ((MethodSignature) signature).getReturnType();
            // 执行目标方法
            Object obj = point.proceed();
//            if (activityTemplatePoint.printReturn()) {
//                Response response = (Response) obj;
//                logger.info("\t{} : Response : code={},msg={}", seriNo, response.getReturn_code(), response.getReturn_msg());
//            }
            long end = System.currentTimeMillis();
//            logger.info("\t{} : Time : {}ms", seriNo, end - start);
//            return obj;
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;


    }
}
