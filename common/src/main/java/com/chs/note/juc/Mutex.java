package com.chs.note.juc;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author : HongSheng.Chen
 * @date : 2020/7/16 15:20
 */
public class Mutex implements Lock, Serializable {

    private static class Sync extends AbstractQueuedLongSynchronizer {
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }


        @Override
        protected boolean tryAcquire(long acquires) {
            assert acquires == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }


        @Override
        protected boolean tryRelease(long releases) {
            assert releases == 1;
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }


        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {

        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
    }


    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    Integer a = 0;

    public static void main(String[] args) throws InterruptedException {

        Mutex mutex = new Mutex();


        Runnable r1 = () -> {

            for (int i = 0; i < 1000; i++) {
                mutex.lock();
                System.out.println(Thread.currentThread().getName() + ":" + mutex.a++);
                mutex.unlock();
            }

        };

        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        Thread.currentThread().join();
    }


}
