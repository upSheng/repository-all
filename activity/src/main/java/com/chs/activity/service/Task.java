package com.chs.activity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/3 15:40
 */
@Slf4j
@Component
@EnableScheduling
public class Task {

    @Scheduled(cron = "0/5 * * * * ?")
    private void taskTest() {

        log.info("task");
    }
}
