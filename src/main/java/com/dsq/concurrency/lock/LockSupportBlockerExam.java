package com.dsq.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by DELL on 2017/9/19.
 * LockSupport还可以用来给线程设置一个Blocker对象，便于调试和检测线程，
 * 其原理是使用Unsafe的putObject方法直接设置Thread对象的parkBlocker属性，
 * 并在合适的时候读取这个Blocker对象
 *
 */

public class LockSupportBlockerExam {
    public static void main(String[] args) {
        Thread t3 = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("t3");
                System.out.println(Thread.currentThread().getName() + " park 5 seconds");
                //park 5 seconds, set blocker
                Object blocker = new String("Alex Wang");
                LockSupport.parkUntil(blocker, System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
                System.out.println(Thread.currentThread().getName() + " after park");
            }
        };
        t3.start();

        try {
            Object t3_blocker = null;
            while (t3_blocker == null) {
                t3_blocker = LockSupport.getBlocker(t3);
                TimeUnit.MILLISECONDS.sleep(10);
            }
            System.out.println("t3 blocker is :" + t3_blocker);
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}