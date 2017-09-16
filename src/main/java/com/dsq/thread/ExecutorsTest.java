package com.dsq.thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DELL on 2017/7/16.
 */
public class ExecutorsTest {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    @Test
    public void shutdown(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
            atomicInteger.decrementAndGet();
        };
        executorService.submit(runnable);
        atomicInteger.addAndGet(1);
        executorService.submit(runnable);
        atomicInteger.addAndGet(1);
        executorService.submit(runnable);
        atomicInteger.addAndGet(1);
        /*while (Thread.activeCount() > 1){
            Thread.yield();
        }*/
        while(atomicInteger.get() != 0){
            Thread.yield();
        }
        executorService.shutdown();
        System.out.println("end");
    }

    @Test
    public void shutdown02(){
        Callable<String> callable = () -> "hello world";
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<String>(executorService);
        executorCompletionService.submit(callable);
        executorCompletionService.submit(callable);
        executorCompletionService.submit(callable);
        for(int i  = 0; i < 3; i++){
            try {
                Future<String> future = executorCompletionService.take();
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }

    @Test
    public void shutdown03(){
        long start = System.currentTimeMillis();
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello world");
        };
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.submit(runnable);
        executorService.shutdown();
        while(!executorService.isTerminated()){
            Thread.yield();
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        System.out.println("end");

    }
}