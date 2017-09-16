package com.dsq.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by DELL on 2017/7/6.
 */
public class FutureTaskTest {

    @Test
    public void test01(){
        String result = null;
        try {
            Callable<String> call = () ->{
                Thread.sleep(3_000);
                return "abc";};
            Runnable r = () -> System.out.println("abc");
            FutureTask<String> task = new FutureTask<String>(call);
            //FutureTask<String> task = new FutureTask<String>(r, "123");
            new Thread(task).start();
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    };
}


