package com.web.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/6/22<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/6/22            创建
 * --------------------------------------------------------------------
 * </pre>
 */

@RestController
public class HelloWorldAction {

    @RequestMapping("/helloWorld")
    public Map<String,Object> helloWorld(HttpServletRequest request){


        String name = request.getRemoteUser();
        Map<String,Object>  map = new HashMap<>();
        map.put("name",name);
        return  map;
    }

    @RequestMapping("/")
    public String home(){

        return  "hello World!";
    }

    @RequestMapping("/data1")
    public String data1(){

        return  "data1";
    }
    @RequestMapping("/data2")
    public String data2(){

        return  "data1";
    }

    @RequestMapping("/success")
    public String success() {
        //这边我们,默认是返到templates下的login.html
        return "success";
    }


}
