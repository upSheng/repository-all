package com.web.modal;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/7 14:50
 */
public class Response<T> {

    private Integer code;
    private String msg;
    private T data;


    public Response() {
        this.code = ResponseCodeEnum.OK.code;
        this.msg = ResponseCodeEnum.OK.msg;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(T data) {
        this.code = ResponseCodeEnum.OK.code;
        this.msg = ResponseCodeEnum.OK.msg;
        this.data = data;
    }

    public Response(ResponseCodeEnum responseCodeEnum, T data) {
        this.code = responseCodeEnum.code;
        this.msg = responseCodeEnum.msg;
        this.data = data;
    }

    public Response(ResponseCodeEnum responseCodeEnum) {
        this.code = responseCodeEnum.code;
        this.msg = responseCodeEnum.msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
