package com.chs.eureka.order;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;


    /**
     * 如果调用失败会执行getUserFallback方法
     * @return
     */
    @RequestMapping("/order/getUser")
    @HystrixCommand(fallbackMethod = "getUserFallback")
    public String getUser() {
        String url = "http://user/user/{id}";
        String info = restTemplate.getForObject(url, String.class, 1);

        return info;

    }

    public String getUserFallback(){
        return "getUser err";
    }
}
