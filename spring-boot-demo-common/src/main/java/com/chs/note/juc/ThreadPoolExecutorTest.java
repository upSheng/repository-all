package com.chs.note.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/1/24<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/1/24            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(5));


        Runnable r = () -> System.out.println("hh");

        Runnable r1 = () -> {
            try {

                while (true) {
                    Thread.sleep(500);
                    System.out.println("hh");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        tpe.execute(r);
        tpe.execute(r1);
        Thread.sleep(1000);
        System.out.println(tpe.getCorePoolSize() + ":" + tpe.getActiveCount() + ":" + tpe.getCompletedTaskCount());


    }
}
