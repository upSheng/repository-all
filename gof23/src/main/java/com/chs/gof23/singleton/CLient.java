package com.chs.gof23.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

public class CLient {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int threadNum = 100;
        final CountDownLatch  countDownLatch = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0; i < 1000000; i++) {
                        SingLeDemo01 singLeDemo01 = SingLeDemo01.getInstance();
                    }
                    countDownLatch.countDown();
                }
            }).start();

        }
        long end = System.currentTimeMillis();

        System.out.println("总耗时:" +(end-start));
    }

    /**
     * 反射  序列化
     * @throws Exception
     */
    private static void reflect() throws Exception {
        Class<SingLeDemo01> clazz = (Class<SingLeDemo01>) Class.forName("com.chs.gof23.singleton.SingLeDemo01");
		Constructor<SingLeDemo01> c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
        SingLeDemo01  s3 = c.newInstance();


        //通过反序列化的方式构造多个对象
        FileOutputStream fos = new FileOutputStream("d:/a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s3);
        oos.close();
        fos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        SingLeDemo01 s4 =  (SingLeDemo01) ois.readObject();


    }
}
