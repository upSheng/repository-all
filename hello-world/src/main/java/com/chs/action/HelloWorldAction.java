package com.chs.action;

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
public class HelloWorldAction {

    @RequestMapping("/helloWorld")
    public Map<String, Object> helloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "helloWorld");
        return map;
    }

    @RequestMapping("/")
    public String home() {
        return "hello World!";
    }

    @RequestMapping("/success1")
    public Map<String, Object> data1() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("cpRewarded", 1);
        return map;
    }

    @RequestMapping("/success0")
    public Map<String, Object> data0() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("cpRewarded", 0);
        return map;
    }

    @RequestMapping("/err")
    public Map<String, Object> data2() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 300);
        map.put("msg", "reward err");
        return map;
    }

}
