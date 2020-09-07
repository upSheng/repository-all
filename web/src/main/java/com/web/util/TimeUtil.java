package com.web.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/23 14:26
 */
public class TimeUtil {

    static void  pp(){
        LocalDateTime of = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String temp = dateTimeFormatter.format(of);
        System.out.println(temp);

        LocalDateTime t2 = LocalDateTime.parse(temp,dateTimeFormatter);
        System.out.println(t2);

        //获取时间戳
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        //时间戳转
        LocalDateTime time2 =LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp),ZoneOffset.of("+8"));
    }
}
