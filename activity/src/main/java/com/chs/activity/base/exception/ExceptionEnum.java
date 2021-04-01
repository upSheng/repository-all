package com.chs.activity.base.exception;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/31 14:06
 */
public enum ExceptionEnum {

    /**
     * 登入错误
     */
    LOGIN_ERR(600, "无此用户或密码错误"),
    REGISTER_ERR(601, "用户名已存在"),
    ORDER_NOT_FIND(602, "订单找不到"),

    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
