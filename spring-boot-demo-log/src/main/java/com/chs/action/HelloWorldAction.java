package com.chs.action;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Slf4j
public class HelloWorldAction {

    @RequestMapping("/helloWorld")
    public Map<String,Object> helloWorld(){
        Map<String,Object>  map = new HashMap<>();
        map.put("msg","helloWorld");

//        Logger logger = LoggerFactory.getLogger(HelloWorldAction.class);
//        logger.info("hhhh******");


       log.info("111");
        return  map;
    }

    @RequestMapping("/")
    public String home(){

        return  "hello World!";
    }
}
