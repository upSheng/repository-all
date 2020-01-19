package com.chs.note.juc;

import java.util.ArrayList;
import java.util.List;

public class Cosumer implements Runnable {
    private List<Integer> container;

    public void setContainer(List<Integer> container) {
        this.container = container;
    }

    public Cosumer(List<Integer> container) {
        this.container = container;
    }

    public void cosume() throws InterruptedException {

        synchronized (container) {
            while (container.isEmpty()) {
                System.out.println("容器没有产品了");
                container.wait();
            }

            int p = container.remove(0);
            System.out.println(Thread.currentThread().getName() + ":消费产品:" + p);

            container.notify();
        }


    }

    @Override
    public void run() {

        while (true) {
            try {
                cosume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> container = new ArrayList<>();

        Thread p = new Thread(new Producer(container));

        Thread c = new Thread(new Cosumer(container));

        p.start();
        c.start();
    }
}
