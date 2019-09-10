package com.chs.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/8/18<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/8/18            创建
 * --------------------------------------------------------------------
 * </pre>
 */

@Controller
public class LoginController {


    @RequestMapping("/login")
    public String hello() {
        //这边我们,默认是返到templates下的login.html
        return "login";
    }


    @RequestMapping("/success")
    public String success() {
        //这边我们,默认是返到templates下的login.html
        return "success";
    }

    @RequestMapping("/index")
    public String index() {
        //这边我们,默认是返到templates下的login.html
        return "index";
    }
}
