package com.chs.eureka.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @Value("${server.port}")
    private int port;

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id){


        if(id==1){
            return "张三" + this.port;
        }else {
            return "李四" + this.port;
        }
    }
}
