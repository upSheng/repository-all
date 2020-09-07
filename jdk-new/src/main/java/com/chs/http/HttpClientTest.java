package com.chs.http;

import com.alibaba.fastjson.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * jdk自带的httpclient
 *
 * @author : HongSheng.Chen
 * @date : 2020/6/23 13:44
 */
public class HttpClientTest {

    private void httpGet() throws Exception {

        String uri = "http://localhost:8081/data/get?name=chs&age=25";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }

    private void httpPost() throws Exception {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("name","chs");
        dataMap.put("age",25);

        String dataStr = JSONObject.toJSONString(dataMap);

        String uri = "http://localhost:8081/data/post";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(dataStr))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());


    }

    /**
     * 单个请求10秒响应
     * 异步10个请求
     * @throws Exception
     */
    private void sleep() throws Exception {
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("name","chs");
        dataMap.put("age",25);

        String dataStr = JSONObject.toJSONString(dataMap);

        String uri = "http://localhost:8081/data/sleep";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(dataStr))
                .build();

        List<CompletableFuture<HttpResponse<String>>> resultList = new ArrayList<>();
        for (int i=0; i<10; i++){
            //CompletableFuture<String> stringCompletableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
            CompletableFuture<HttpResponse<String>> CompletableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            resultList.add(CompletableFuture);
        }

        for (CompletableFuture<HttpResponse<String>> completableFuture: resultList){
            HttpResponse<String> httpResponse = completableFuture.get();
            System.out.println(httpResponse.statusCode());
            System.out.println(httpResponse.body());
        }


    }

    public static void main(String[] args) throws Exception {
        HttpClientTest httpClientTest = new HttpClientTest();
        //httpClientTest.httpGet();
        //httpClientTest.httpPost();
        httpClientTest.sleep();
    }
}
