package com.chs.note.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陈洪生<br>
 * <b>mail</b> chenhongsheng@tansun.com.cn<br>
 * <b>date</b> 2020/2/7<br>
 * @version 1.0.1
 * <pre>
 * 版本            修改人            修改日期            修改内容描述
 * --------------------------------------------------------------------
 * 1.0.1 	       陈洪生	        2020/2/7            创建
 * --------------------------------------------------------------------
 * </pre>
 */
public class ReentrantLockTest {


    private  static Integer count = 0;
    public static void main(String[] args) {


        ReentrantLock reentrantLock = new ReentrantLock(true);

        Runnable r = new Runnable() {
            @Override
            public void run() {

                while (true){
                    reentrantLock.lock();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+count);
                    count++;
                    reentrantLock.unlock();
                }
            }
        };


        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();






    }
}
