package com.chs.task.element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/21 19:37
 */
@Component
public class AsyncTask {

    @Autowired
    AddService addService;

    @Async("taskExecutor")
    public Future<String> tesTask(int i) {

        Future<String> future = new AsyncResult<>("");
        System.out.println(Thread.currentThread().getName() + "-----" + i);

        return future;
    }

    @Async("taskExecutor")
    public void stringTask(String str) {

        System.out.println(Thread.currentThread().getName() + str);
    }

    @Async("taskExecutor")
    public void add(int i) {


        System.out.println(Thread.currentThread().getName() + "-----" + i + addService.toString());
    }
}
