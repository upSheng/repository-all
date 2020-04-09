package com.chs.action;

import com.chs.error.BussinessException;
import com.chs.error.EmBusinessError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class HelloWorldAction extends BaseController {

    @RequestMapping("/helloWorld")
    public Map<String,Object> helloWorld(HttpServletRequest request) throws Exception {

        String name = request.getParameter("name");
        if(name == null){
            throw new BussinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        Map<String,Object>  map = new HashMap<>();
        map.put("msg","helloWorld");
        return  map;
    }

    @RequestMapping("/")
    public String home(){

        return  "hello World!";
    }
}
