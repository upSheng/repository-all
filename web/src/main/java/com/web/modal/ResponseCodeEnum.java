package com.web.modal;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/7 14:55
 */
public enum ResponseCodeEnum {


    OK(200, "ok"),
    FAIL(400, "fail"),

    NO_PERMISSION(501,"nNeed Authorities!"),

    ;


    Integer code;
    String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
