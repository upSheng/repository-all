package com.chs.activity.controller;

import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.vo.LoginResVO;
import com.chs.activity.modal.vo.UserVO;
import com.chs.activity.service.UserLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserVO userVO) {
        return ResponseEntity.withRes(res -> userLoginService.register(userVO.getName(), userVO.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResVO> login(@RequestBody UserVO userVO) {
        return ResponseEntity.withRes(res -> res.setData(userLoginService.login(userVO.getName(), userVO.getPassword())));
    }
}
