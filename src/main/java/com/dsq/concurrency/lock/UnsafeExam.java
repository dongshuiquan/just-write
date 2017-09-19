package com.dsq.concurrency.lock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * Created by DELL on 2017/9/19.
 * park方法用来阻塞一个线程，第一个参数用来指示后面的参数是绝对时间还是相对时间，true表示绝对时间，false表示从此刻开始后的相对时间。调用park的线程就阻塞在此处。
 * upark用来释放某个线程的阻塞，线程用参数var1表示。
 */
public class UnsafeExam {
    @Before
    public void before() {
        System.out.println(System.currentTimeMillis());
    }
    @After
    public void after() {
        System.out.println(System.currentTimeMillis());
    }
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("t1");
                System.out.println(Thread.currentThread().getName() + " before part");
                unsafe.park(false, TimeUnit.NANOSECONDS.convert(100, TimeUnit.SECONDS));
                System.out.println(Thread.currentThread().getName() + " after park") ;
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("t2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " unpart t1");
                unsafe.unpark(t1);
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("t3");
                System.out.println(Thread.currentThread().getName() + " part 5 seconds");
                unsafe.park(true, System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
                System.out.println(Thread.currentThread().getName() + " after park") ;
            }
        };
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
    }
}
