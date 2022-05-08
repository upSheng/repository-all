package com.chs.bi.base.response;


import com.chs.bi.base.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.function.Consumer;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {

    private Integer code;

    private String msg;

    private T data;


    public static <T> ResponseEntity<T> withRes(Consumer<ResponseEntity<T>> consumer) {
        long start = System.currentTimeMillis();
        ResponseEntity<T> res = new ResponseEntity<T>();
        res.setCode(200);
        try {
            consumer.accept(res);
            long delta = System.currentTimeMillis() - start;

            if (StringUtils.isEmpty(res.getMsg())) {
                res.setMsg("succeeded with " + delta + " ms");
            }
        } catch (BusinessException ex) {
            res.setCode(ex.getCode());
            res.setMsg(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            res.setCode(500);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<>(200, null, data);
    }

    public static <T> ResponseEntity<T> fail(Integer code, String msg) {
        return new ResponseEntity<>(code, msg, null);
    }

}
