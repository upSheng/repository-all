package com.web.util;

import org.springframework.context.ApplicationContext;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/23 14:34
 */
public class ApplicationContextUtil {
    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
