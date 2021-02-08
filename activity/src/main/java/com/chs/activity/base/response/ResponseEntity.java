package com.chs.activity.base.response;


import com.chs.activity.base.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.function.Consumer;

/**
 * @author : HongSheng.Chen
 * @date : 2020/12/23 17:37
 */
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
            res.setCode(500);
            res.setMsg(ex.getMessage());
        }
        return res;
    }
}
