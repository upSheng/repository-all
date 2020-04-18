package com.chs.jpa;

import com.chs.jpa.entity.User;
import com.chs.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/9/21<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/9/21            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UsersRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        Random random = new Random();


        User user = new User();
        for (int i = 0; i < 1000000; i++) {
            user.setAge(random.nextInt(100));
            user.setName("张三" + i);
            user.setPassword(UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            user.setCreateUser(UUID.randomUUID().toString());
            user.setId(null);
            this.userRepository.save(user);
        }
    }

    @Test
    public void testDelete() {

        this.userRepository.deleteById("005daeb881-3333-4cd8-8f1f-09a5bdb35766");
    }

    @Test
    public void testFind() {

        User user = new User();
        user.setName("zz");
        Page<User> userList2 = this.userRepository.findAll(Example.of(user), PageRequest.of(1, 3));

    }


}
