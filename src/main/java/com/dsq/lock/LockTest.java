package com.dsq.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DELL on 2017/7/16.
 */
public class LockTest {

    @Test
    public void testToString(){
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            System.out.println(lock);
        }finally {
            lock.unlock();
            System.out.println(lock);
        }
    }
}
