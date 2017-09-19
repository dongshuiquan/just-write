package com.dsq.concurrency.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by DELL on 2017/9/19.
 */
public class SimpleLock {
    private static class Sync extends AbstractQueuedSynchronizer {
        protected Sync() {
            super();
        }

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }
    }
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    private static class MyThread extends Thread {
        private final String name;
        private final SimpleLock lock;

        public MyThread(String name, SimpleLock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println(name + " get the lock");
            try {
                // TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + " release the lock");
                lock.unlock();
            }
        }
    }

    public void main() {
        final SimpleLock lock = new SimpleLock();
        MyThread t1 = new MyThread("t1", lock);
        MyThread t2 = new MyThread("t2", lock);
        MyThread t3 = new MyThread("t3", lock);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread exit!");
    }

    @Test
    public void test() {
        for(int i = 0; i < 100; i++) {
            main();
        }
    }
}
