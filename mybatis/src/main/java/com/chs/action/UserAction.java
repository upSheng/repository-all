package com.chs.action;

import com.chs.dao.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2020/6/9 20:47
 */
@RestController
public class UserAction {

    @Autowired
    private UserEntityMapper userEntityMapper;

    @RequestMapping("/data")
    public Map data() {

        Map<String, Object> result = new HashMap<>();
        userEntityMapper.selectAll();
        return result;
    }
}
