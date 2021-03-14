package com.chs.activity.controller;


import com.chs.activity.element.DistributionLock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 20:16
 */
@RestController
public class ActivityWheel {

    @Resource
    DistributionLock distributionLock;

    @RequestMapping("/wheel")
    public String wheel() {

        String key = "lockName";
        boolean lockName = distributionLock.tryLock(key, 2000L, 10000L);
        if (!lockName) {
            return "wait";
        }
        distributionLock.unlock(key);
        Random random = new Random();

        return String.valueOf(random.nextInt(10));
    }
}
