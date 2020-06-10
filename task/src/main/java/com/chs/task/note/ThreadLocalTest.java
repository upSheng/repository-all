package com.chs.task.note;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/27 9:40
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<String> str = new ThreadLocal<>();

        Runnable runnableOne = () -> {

            try {
                str.set("11");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":" + str.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnableTwo = () -> {

            try {
                str.set("22");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ":" + str.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnableOne).start();
        new Thread(runnableTwo).start();

    }
}
