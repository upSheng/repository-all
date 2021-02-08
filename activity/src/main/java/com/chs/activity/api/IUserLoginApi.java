package com.chs.activity.api;

import com.chs.activity.base.response.ResponseEntity;
import com.chs.activity.modal.vo.LoginResVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 11:14
 */
@RequestMapping("/user")
public interface IUserLoginApi {

    @PostMapping("/register")
    ResponseEntity<Void> register(@RequestParam("userId") String userId, @RequestParam("password") String password);


    @PostMapping("/login")
    ResponseEntity<LoginResVO> login(@RequestParam("userId") String userId, @RequestParam("password") String password);
}
