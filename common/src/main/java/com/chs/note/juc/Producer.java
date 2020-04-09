package com.chs.note.juc;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {


    private List<Integer> container;


    private Integer capacity = 5;

    public Producer(List<Integer> container) {
        this.container = container;
    }

    public void setContainer(List<Integer> container) {
        this.container = container;
    }

    public void produce() throws InterruptedException {


        synchronized (container) {
            while (container.size() >= capacity) {
                System.out.println("容器已经满了");
                container.wait();
            }
            Random r = new Random();
            int p = r.nextInt(50);
            System.out.println(Thread.currentThread().getName() + ":生产产品:" + p);
            container.add(p);

            container.notify();
        }

    }

    @Override
    public void run() {

        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
