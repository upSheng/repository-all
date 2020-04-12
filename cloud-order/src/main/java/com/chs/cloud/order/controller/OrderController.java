package com.chs.cloud.order.controller;

import com.chs.api.order.OrderApi;
import com.chs.cloud.order.feign.UserFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController implements OrderApi {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserFeign userFeign;


    /**
     * 如果调用失败会执行getUserFallback方法
     *
     * @return
     */

    @HystrixCommand(fallbackMethod = "getUserFallback")
    @Override
    public String getUser(@RequestParam("id") int id) {
//        String url = "http://user/user/{id}";
//        String info = restTemplate.getForObject(url, String.class, 1);

        String info = userFeign.getUser(id);
        return info;

    }

    public String getUserFallback(int id) {
        return "getUser err";
    }
}
