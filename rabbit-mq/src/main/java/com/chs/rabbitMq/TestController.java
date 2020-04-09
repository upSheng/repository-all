package com.chs.rabbitMq;

import org.springframework.beans.factory.annotation.Autowired;
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
 * <b>date</b> 2019/10/9<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/10/9            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg){
        sender.send(msg);
        return "ok";
    }
}
