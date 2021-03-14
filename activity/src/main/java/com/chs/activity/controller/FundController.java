package com.chs.activity.controller;

import com.chs.activity.service.FundService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : HongSheng.Chen
 * @date : 2021/2/28 11:13
 */

@RestController
public class FundController {

    @Resource
    FundService fundService;


    public Map<String, Object> data(@RequestParam("code") String code) {
        return fundService.data(code);
    }


    public void exportCsv(@RequestParam("code") String code) {
        fundService.exportCsv(code);
    }
}
