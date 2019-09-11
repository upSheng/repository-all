package com.chs.eureka.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/order/getUser")
    public String getUser() {
        String url = "http://user/user/{id}";
        String info = restTemplate.getForObject(url, String.class, 1);

        return info;

    }
}
