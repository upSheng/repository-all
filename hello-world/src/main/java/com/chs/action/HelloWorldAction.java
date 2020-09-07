package com.chs.action;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @RequestMapping("/")
    public String home() {
        return "hello World!";
    }

    @RequestMapping("/data")
    public Map<String, Object> data() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "chs");
        map.put("age", 25);
        map.put("createTime",new Date());
        return map;
    }

    @RequestMapping("/data/get")
    public Map<String, Object> get(@RequestParam Map<String,Object> params) {
        return params;
    }

    @RequestMapping("/data/post")
    public Map<String, Object> post(@RequestBody Map<String,Object> params) {
        return params;
    }

    @RequestMapping("/data/sleep")
    public Map<String, Object> sleep()  {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", "chs");
        map.put("age", 25);
        map.put("createTime",new Date());
        return map;
    }

}
