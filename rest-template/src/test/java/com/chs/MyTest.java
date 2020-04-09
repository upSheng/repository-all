package com.chs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.util.*;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2019/7/27<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2019/7/27            创建
 * --------------------------------------------------------------------
 * </pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})// 指定启动类
public class MyTest {

    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void t1() {


//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//添加请求的参数

        params.add("mchid", "1547187151");
        params.add("total_fee", "1");
        params.add("out_trade_no", "order22");
        params.add("body", "你body");
        params.add("attach", "data");
        //params.add("id", "id001");
//        paramMap.add("notify_url","");
//        paramMap.add("type","");


        //签名
        Collection<String> keyset = params.keySet();
        List<String> keyList = new ArrayList<>(keyset);
        Collections.sort(keyList);
        StringBuilder sb = new StringBuilder();
        for (String key : keyList) {
            sb.append(key).append("=").append(params.getFirst(key)).append("&");
        }
        sb.append("key=").append("LfFjXZ6ANijkPSEC");
        String sign = DigestUtils.md5DigestAsHex(sb.toString().getBytes());
        params.add("sign", sign.toUpperCase());


        //HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity(params, headers);
//  执行HTTP请求

        String url = "https://payjs.cn/api/native";
        //url = "http://localhost:8080/data";
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);  //最后的参数需要用String.class  使用其他的会报错
//        String body = response.getBody();
//        if (body != null) {
//            JSONObject data = (JSONObject) JSON.parse(body);
//            System.out.println(data.toJSONString());
//        } else {
//
//        }

        JSONObject result = restTemplate.postForObject(url,params,JSONObject.class);
        System.out.println(result.toJSONString());

    }


}
