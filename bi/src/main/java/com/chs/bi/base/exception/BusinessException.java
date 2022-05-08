package com.chs.bi.base.exception;

import lombok.Data;


@Data
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(int code, String message, Object... args) {
        super(String.format(message, args));
        this.code = code;
    }

    public static BusinessException of(String message, Object... args) {
        return new BusinessException(500, message, args);
    }

    public static BusinessException of(ExceptionEnum exceptionEnum, Object... args) {
        return new BusinessException(exceptionEnum.getCode(), exceptionEnum.getMsg(), args);
    }

}
