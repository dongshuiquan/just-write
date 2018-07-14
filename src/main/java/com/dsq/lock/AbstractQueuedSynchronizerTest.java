package com.dsq.lock;


import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DELL on 2018/6/19.
 */

public class AbstractQueuedSynchronizerTest {

    @Test
    public void testAbstractQueuedSynchronizer() throws InterruptedException {
        Lock lock = new ReentrantLock();

        Runnable runnable0 = new ReentrantLockThread(lock);
        Thread thread0 = new Thread(runnable0);
        thread0.setName("线程0");

        Runnable runnable1 = new ReentrantLockThread(lock);
        Thread thread1 = new Thread(runnable1);
        thread1.setName("线程1");

        Runnable runnable2 = new ReentrantLockThread(lock);
        Thread thread2 = new Thread(runnable2);
        thread2.setName("线程2");

        thread0.start();
        thread1.start();
        thread2.start();

      /*  try {
            thread0.join();
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        TimeUnit.SECONDS.sleep(1000);

    }

    private class ReentrantLockThread implements Runnable {

        private Lock lock;

        public ReentrantLockThread(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                //for (;;) ;
                //Scanner sb = new Scanner(System.in);
                //sb.nextLine();
                TimeUnit.SECONDS.sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}