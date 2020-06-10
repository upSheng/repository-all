package com.chs.task.note;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : HongSheng.Chen
 * @date : 2020/5/22 20:09
 */
public class WaitNotifyTest {

    private static Queue<Integer> queue = new LinkedList<>();
    private static final Integer MAX = 10;
    private static Integer index = 0;

    public static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                synchronized (queue) {

                    while (true) {
                        Thread.sleep(500);
                        if (queue.size() < MAX) {
                            queue.add(index);
                            System.out.println("produce:" + index);
                            index++;
                        } else {
                            System.out.println("produce is max");
                            queue.notify();
                            queue.wait();
                        }
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                synchronized (queue) {

                    while (true) {
                        Thread.sleep(500);
                        if (queue.isEmpty()) {
                            queue.notify();
                            queue.wait();
                        } else {
                            System.out.println("cosumer: " + queue.poll());

                        }
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
