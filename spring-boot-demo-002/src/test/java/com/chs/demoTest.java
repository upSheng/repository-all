package com.chs;

import com.chs.dao.UserMapper;
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
@SpringBootTest(classes={Application.class})// 指定启动类
public class demoTest {



    @Autowired
    private UserMapper userMapper;

    @Test
    public void testOne(){
        System.out.println("test hello 1");

    }

    @Test
    public void test(){

        System.out.println("test hello 1");
        User user =userMapper.findByIdA("11");
        System.out.println(user.getName());

        user =userMapper.findById("11");
        System.out.println(user.getName());

    }

    @Test
    public void test1(){


        List<Map<String,Object>> list =userMapper.findMapById("11");

        for (Map<String,Object> map: list){
            System.out.println(map.toString());
        }




    }
}
