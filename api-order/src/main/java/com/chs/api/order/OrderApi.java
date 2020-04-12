package com.chs.api.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/12 19:24
 */
@RequestMapping("order")
public interface OrderApi {
    @RequestMapping("getUser")
    String getUser(@RequestParam("id") int id);
}
