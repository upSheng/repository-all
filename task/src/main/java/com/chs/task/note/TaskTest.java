package com.chs.task.note;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/22 19:31
 */
public class TaskTest {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("第一种方式线程");
        }
    }

    public static class RunableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("第二种方式线程");
        }
    }

    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("第三种方式线程");
            return "hello";
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new RunableTask()).start();

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());

        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
