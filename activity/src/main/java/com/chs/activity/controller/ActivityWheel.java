package com.chs.activity.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 20:16
 */
@RestController
public class ActivityWheel {

    @RequestMapping("/wheel")
    public String wheel() {

        return "adsd";
    }
}
