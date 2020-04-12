package com.chs.api.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : HongSheng.Chen
 * @date : 2020/4/12 17:48
 */

@RequestMapping("/user")
public interface UserApi {

    @RequestMapping("/{id}")
    String getUser(@PathVariable("id") int id);
}
