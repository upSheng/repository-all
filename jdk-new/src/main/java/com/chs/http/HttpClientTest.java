package com.chs.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * jdk自带的httpclient
 *
 * @author : HongSheng.Chen
 * @date : 2020/6/23 13:44
 */
public class HttpClientTest {

    private void httpGet() throws Exception {
        String data = "{\"name\":\"chs\"}";
        String uri = "http://localhost:8081/success0";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        CompletableFuture<String> stringCompletableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
        System.out.println(stringCompletableFuture.get());

    }

    public static void main(String[] args) throws Exception {
        HttpClientTest httpClientTest = new HttpClientTest();
        httpClientTest.httpGet();
    }
}
