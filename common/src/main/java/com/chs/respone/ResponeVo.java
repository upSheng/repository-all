package com.chs.respone;

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
public class ResponeVo {

    private String status;
    private Object data;

    //定义一个通用的创建方法
    public static ResponeVo create(Object result) {
        return ResponeVo.create(result, "success");

    }

    public static ResponeVo create(Object result, String status) {
        ResponeVo responeVo = new ResponeVo();
        responeVo.setStatus(status);
        responeVo.setData(result);
        return responeVo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
