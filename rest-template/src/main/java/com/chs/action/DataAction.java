package com.chs.action;

import com.chs.modal.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
public class DataAction {

    @RequestMapping("/data")
    public Map<String, Object> data(@RequestParam("name") String name) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return map;
    }


    @RequestMapping("/bodyData")
    public Map<String, Object> data(@RequestBody User user) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        return map;
    }

    @RequestMapping("/bodyDataMap")
    public Map<String, Object> data(@RequestBody Map user) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", user.get("name"));
        return map;
    }

    @RequestMapping("/comment")
    public Map<String,Object> comment(@RequestBody Map map){
        Map<String,Object> result = new HashMap<>();
        result.put("return_code",200);
        result.put("data", UUID.randomUUID().toString());
        return result;
    }


}
