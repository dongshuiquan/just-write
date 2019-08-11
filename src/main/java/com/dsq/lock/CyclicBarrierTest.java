package com.dsq.lock;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        new CyclicBarrierTest().test01();
    }
    @Test
    public void test01() {
        int num = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num);

        for(int i = 0; i < num; i++) {
            Thread t = new Thread("t-" + i) {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(5 * 1000));
                        System.out.println(getName());
                        int await = cyclicBarrier.await();
                        System.out.println(getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        System.out.println("end");

     }
}
