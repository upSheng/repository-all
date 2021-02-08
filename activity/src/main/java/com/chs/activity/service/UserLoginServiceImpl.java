package com.chs.activity.service;

import com.chs.activity.modal.vo.LoginResVO;
import com.chs.activity.utils.JwtUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/24 11:23
 */
@Service
public class UserLoginServiceImpl {


    public void register(String userId, String password) {

    }


    public LoginResVO login(@RequestParam("userId") String userId, @RequestParam("password") String password) {

        String token = JwtUtils.creatToken(userId, 10 * 60 * 1000L);
        return new LoginResVO(token);
    }
}
