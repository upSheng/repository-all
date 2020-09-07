package com.chs.note.juc;

import java.util.concurrent.*;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/13 15:37
 */
public class ExecutorServiceTest {

    static class Sing implements Callable<Integer>{
        String name;
        long time;
        Sing(String name,long time){
            this.name = name;
            this.time = time;

        }
        @Override
        public Integer call() throws Exception {

            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName()+":"+name+":"+time);
            return null;
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> cat = executorService.submit(new Sing("cat", 1000 * 50));
        executorService.submit(new Sing("cat",1000));
        executorService.submit(new Sing("cat",1000*10));
        executorService.submit(new Sing("cat",1000*20));

        try {
            cat.get();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
