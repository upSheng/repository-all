package com.chs.activity.base.exception;

import lombok.Data;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 17:52
 */
@Data
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(int code, String message, Object... args) {
        super(String.format(message, args));
        this.code = code;
    }

    public BusinessException(String message, Object... args) {
        super(String.format(message, args));
        code = 500;
    }
}
