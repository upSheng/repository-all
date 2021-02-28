package com.chs.activity.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/28 11:12
 */
@RequestMapping("/fund")
public interface IFundApi {

    @CrossOrigin
    @GetMapping("/data")
    Map<String, Object> data(String code);
}
