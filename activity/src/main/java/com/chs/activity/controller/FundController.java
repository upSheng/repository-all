package com.chs.activity.controller;

import com.chs.activity.api.IFundApi;
import com.chs.activity.service.FundService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/28 11:13
 */
@RestController
public class FundController implements IFundApi {

    @Resource
    FundService fundService;

    @Override
    public Map<String, Object> data(String code) {
        return fundService.data(code);
    }
}
