package com.chs.note.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/1/23<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/1/23            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class AtomicIntegerTest {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(200);
        AtomicInteger aCount = new AtomicInteger(0);


        for (int i = 0; i < 100; i++) {
            new Thread(() -> {

                for (int j = 0; j < 1000; j++) {
                    aCount.getAndIncrement();//自增

                }
                countDownLatch.countDown();
            }).start();
            new Thread(() -> {

                for (int j = 0; j < 1000; j++) {
                    count++;

                }
                countDownLatch.countDown();
            }).start();

        }

        //Thread.sleep(2000);

        countDownLatch.await();
        System.out.println(aCount.get());
        System.out.println(count);


    }


}
