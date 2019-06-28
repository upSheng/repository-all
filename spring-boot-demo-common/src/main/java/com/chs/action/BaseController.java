package com.chs.action;

import com.chs.error.BussinessException;
import com.chs.error.EmBusinessError;
import com.chs.respone.ResponeVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
 * <b>date</b> 2019/6/28<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/6/28            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class BaseController {


    //定义exceptionghandler解决为被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {

        //必须自己封装data对象，否则data为exception反序列化的对象
        Map<String,Object> responseData = new HashMap<>();

        if(ex instanceof BussinessException){
            BussinessException bussinessException = (BussinessException) ex;
            responseData.put("errCode",bussinessException.getErrCode());
            responseData.put("errMsg",bussinessException.getErrMsg());
        } else {
            responseData.put("errCode", EmBusinessError.UNKNOW_ERROR.getErrCode());
            responseData.put("errMsg",EmBusinessError.UNKNOW_ERROR.getErrMsg());

        }
        return ResponeVo.create(responseData,"fail");

    }
}
