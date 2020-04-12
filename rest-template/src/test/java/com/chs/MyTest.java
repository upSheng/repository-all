package com.chs;

import com.alibaba.fastjson.JSONObject;
import com.chs.util.SignUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


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

    }

    /**
     * param
     */
    @Test
    public void test2() {

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("name", "chs");
        String url = "http://localhost:8080/data";
        JSONObject result = restTemplate.postForObject(url, params, JSONObject.class);
        System.out.println(result);
    }

    /**
     * body
     */
    @Test
    public void test3() {

        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);

        Map<String, Object> params = new HashMap<>();
        params.put("name", "chs");
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(params, httpHeaders);

        String url = "http://localhost:8080/bodyData";
        JSONObject result = restTemplate.postForObject(url, objectHttpEntity, JSONObject.class);
        System.out.println(result);
    }

    @Test
    public void test4() {

        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type = MediaType.APPLICATION_JSON_UTF8;
        httpHeaders.setContentType(type);

        Map<String, Object> params = new HashMap<>();
        params.put("cpOrderId", "1570773342696");
        params.put("send", "1");

        //签名
        String appSecret = "eee3458c725c15c290b2b94b6eb48881";
        String sign = SignUtil.createSign(params,appSecret);
        params.put("sign", sign);
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(params, httpHeaders);

        String url = "http://test2500.233xyx.com/apiserv/api/intermodal/v3/handleCPAwardBack";
        JSONObject result = restTemplate.postForObject(url, objectHttpEntity, JSONObject.class);
        System.out.println(result);

    }


}
