package com.chs.cloud.user.controller;

import com.chs.api.user.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements UserApi {

    @Value("${server.port}")
    private int port;

    @Override
    public String getUser(@PathVariable("id") int id) {

        if (id == 1) {
            return "张三" + this.port;
        } else {
            return "李四" + this.port;
        }
    }
}
