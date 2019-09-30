package com.web.action;

import com.web.entity.User;
import com.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("name") String name, @RequestParam("password") String password){

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        iUserService.save(user);

        return "ok";

    }
}
