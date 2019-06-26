package com.chs.configuration;

import com.chs.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class configurationTest {


    @Autowired
    private UserProperties userProperties;



    @Test
    public void updateByEntityTest() {

        System.out.println(userProperties.getName());
        System.out.println(userProperties.getRealName());
    }




}
