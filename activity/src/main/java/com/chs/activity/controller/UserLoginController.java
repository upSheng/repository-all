package com.chs.activity.controller;

import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.vo.LoginResVO;
import com.chs.activity.service.UserLoginService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 10:45
 */
@RestController
public class UserLoginController {

    @Resource
    UserLoginService userLoginService;


    public ResponseEntity<Void> register(@RequestParam("userId") String userId, @RequestParam("password") String password) {
        return ResponseEntity.withRes(res -> userLoginService.register(userId, password));
    }


    public ResponseEntity<LoginResVO> login(@RequestParam("userId") String userId, @RequestParam("password") String password) {
        return ResponseEntity.withRes(res -> res.setData(userLoginService.login(userId, password)));
    }
}
