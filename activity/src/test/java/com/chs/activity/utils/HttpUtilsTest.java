package com.chs.activity.utils;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author : HongSheng.Chen
 * @date : 2021/3/10 9:53
 */
class HttpUtilsTest {

    @Test
    void sendPost() {

        Map<String, String> payData = new TreeMap<>();
        payData.put("mchid", "1547187151");
        payData.put("total_fee", "10");
        payData.put("out_trade_no", "123456"); // 订单号 随便输的，自己生成一下就好了
        payData.put("body", "test");
        //payData.put("notify_url", "https://你的域名/api/pay/notify");

        // 进行sign签名
        payData.put("sign", SignUtils.sign(payData, "LfFjXZ6ANijkPSEC"));

        String url = "https://payjs.cn/api/native";
        String s = HttpUtils.sendPost(url, payData);
        System.out.println(s);
    }
}