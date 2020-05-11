package com.chs.action;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
public class HelloWorldAction {

    @RequestMapping("/helloWorld")
    public Map<String,Object> helloWorld(){
        Map<String,Object>  map = new HashMap<>();
        map.put("msg","helloWorld");
        log.info("info");
        log.debug("debug");

        try {
            int a = 1/0;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            map.put("msg","err");
            return map;

        }
        return  map;
    }

    @RequestMapping("/")
    public String home(){

        return  "hello World!";
    }
}
