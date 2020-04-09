package com.chs.note.juc;

public class VolatileTest {
    private static class VolatileVar implements Runnable{

        public static Object o = new Object();
        private volatile     Boolean flag = true; //有volatile和没volatile效果明显
        @Override
        public void run() {
            while (true) {

                if(flag){
                    System.out.println(Thread.currentThread().getName()+":>>>>>"+flag);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileVar v = new VolatileVar();
        Thread t1 = new Thread(v);


        t1.start();


        Thread.sleep(500);
        v.flag=false;
        System.out.println("I sleep 3s");
        Thread.sleep(3000);
        System.out.println("I will start now");
        v.flag=true;


    }
}
