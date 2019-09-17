package com.chs.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class Task {

    @Value("${server.port}")
    private int port;

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    private void taskTest(){
        try{

            String taskCode = "task001";
            String ip = InetAddress.getLocalHost().getHostAddress();
            Boolean flag =   redisTemplate.opsForValue().setIfAbsent(taskCode,ip,3, TimeUnit.SECONDS);

            if(flag !=null && flag){
                System.out.println(ip+":"+port +"  "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}