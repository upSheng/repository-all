package com.web.service.impl;

import com.web.Application;
import com.web.entity.User;
import com.web.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class UserServiceImplTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void findByName() {

        User user = iUserService.findByName("zhangsan");
    }

    @Test
    public void save() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("chs");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        iUserService.save(user);

    }

    @Test
    public void deleteById() {
    }


}