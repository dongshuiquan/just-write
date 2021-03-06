package com.dsq.concurrency.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by DELL on 2017/9/19.
 */
public class SimpleSharedLock {
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            return compareAndSetState(0, 1) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(0);
            return true;
        }

        protected Sync() {
            super();
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }

    private static class MyThread extends Thread {
        private final String name;
        private final SimpleSharedLock lock;

        private MyThread(String name, SimpleSharedLock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(name + " get the lock");
                // TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(name + " release the lock");
            }
        }
    }

    public void main() {
        final SimpleSharedLock lock = new SimpleSharedLock();
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