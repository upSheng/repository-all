package com.chs.activity.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 20:16
 */
@RestController
public class ActivityWheel {

    @RequestMapping("/wheel")
    public String wheel() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10));
    }
}
