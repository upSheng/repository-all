package com.chs;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/7 17:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class Notify {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test2() {

        String orderIds = "M4C59_1012104474_5318e76c54_1588821537110,M4C59_1012104474_5ec5861f24_1588821542152";
        List<String> orderList = Arrays.asList(orderIds.split(","));
        String url = "";

        for(String orderId: orderList){
            MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
            params.add("orderId", orderId);
            JSONObject result = restTemplate.postForObject(url, params, JSONObject.class);
            System.out.println(orderId+":"+result.toJSONString());
        }

    }
}
