package com.chs.dao;

import com.chs.Application;
import com.chs.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/6/25<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/6/25            创建
 * --------------------------------------------------------------------
 * </pre>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void findByIdTest() {
        User user = userMapper.findByIdA("11");
        System.out.println(user.getName());

    }

    @Test
    public void findByIdATest() {
        User user = userMapper.findByIdA("11");
        System.out.println(user.getName());

    }

    @Test
    public void findMapByIdTest() {

        List<Map<String, Object>> list = userMapper.findMapById("11");

        for (Map<String, Object> map : list) {
            System.out.println(map.toString());
        }
    }


    @Test
    public void deleteByIdTest() {
        userMapper.deleteById("c70112f7-03a7-4272-beb5-cc925ce3f47b");
    }

    @Test
    public void updateByEntityTest() {
        User user = userMapper.findById("11");
        user.setName("哈哈");
        userMapper.updateByEntity(user);
    }
}
