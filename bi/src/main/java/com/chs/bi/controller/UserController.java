package com.chs.bi.controller;

import com.chs.bi.base.response.EasyPage;
import com.chs.bi.base.response.ResponseEntity;
import com.chs.bi.model.entity.User;
import com.chs.bi.model.vo.UserQuery;
import com.chs.bi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    IUserService userService;

    @PostMapping("/userAdd")
    public ResponseEntity<User> userAdd(@RequestBody User user) {

        return ResponseEntity.withRes(res -> res.setData(userService.insert(user)));
    }

    @PostMapping("/userQuery")
    public ResponseEntity<EasyPage<User>> userQuery(@RequestBody UserQuery userQuery) {
        return ResponseEntity.withRes(res -> res.setData(userService.selectPage(userQuery)));
    }
}
