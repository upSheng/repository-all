package com.chs.http;

import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * jdk自带的httpclient
 *
 * @author : HongSheng.Chen
 * @date : 2020/6/23 13:44
 */
public class HttpClientYs {

    /**
     * 单个请求10秒响应
     * 异步10个请求
     *
     * @throws Exception
     */
    private void sleep() throws Exception {

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(20, 50, 200, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(5000000));

        String prefix = "https://img.topgamers.cn/";

        String path = "D:/ysimg/";
        List<CompletableFuture<HttpResponse<Path>>> resultList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            for (int x = 0; x < 100; x++) {
                for (int y = 0; y < 100; y++) {

                    StringBuilder sb = new StringBuilder();
                    sb.append("activityyuanshen_yuan");
                    sb.append("_").append(i);
                    sb.append("_").append(x);
                    sb.append("_").append(y);
                    sb.append(".png");
                    String name = sb.toString();

                    tpe.submit(new ImgTask(prefix, name, path));

                }
            }
        }


        tpe.shutdown();
        while (true) {
            Thread.sleep(1000);
            System.out.println(tpe.getCompletedTaskCount());
            if (tpe.isTerminated()) {
                System.out.println("结束");
                break;
            }

        }


    }

    public static void main(String[] args) throws Exception {
        HttpClientYs httpClientTest = new HttpClientYs();
        httpClientTest.sleep();
    }
}
