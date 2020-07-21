package com.web.controller;

import com.web.entity.UserEntity;
import com.web.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/30<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/30            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@Api("helloWorld 测试")
@RestController
@RequestMapping(value = "adasda")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @ApiOperation(httpMethod = "GET",value = "test - chs")
    @RequestMapping("/addUser")
    public String addUser(@RequestParam("name") String name, @RequestParam("password") String password) {

        UserEntity user = new UserEntity();

        user.setName(name);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.save(user);

        return "ok";

    }
}
