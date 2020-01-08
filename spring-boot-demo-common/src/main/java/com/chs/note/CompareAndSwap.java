package com.chs.note;

public class CompareAndSwap {
    private int value;

    //获取内存值
    public synchronized int get() {
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }

    //比较
    public synchronized Boolean cc(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue == expectedValue;
    }

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int expectedValue = cas.get();
                    Boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));

                    System.out.println(b);


                }
            }).start();
        }
    }


}
