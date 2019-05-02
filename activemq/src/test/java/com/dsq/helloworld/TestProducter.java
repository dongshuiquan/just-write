package com.dsq.helloworld;

/**
 * Created by dong on 2019/5/2.
 */
public class TestProducter {
    public static void main(String[] args){
        Producer producer = new Producer();
        producer.init();
        TestProducter testMq = new TestProducter();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 2
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 3
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 4
        new Thread(testMq.new ProductorMq(producer)).start();
        //Thread 5
        new Thread(testMq.new ProductorMq(producer)).start();
    }

    private class ProductorMq implements Runnable{
        Producer producer;
        public ProductorMq(Producer producer){
            this.producer = producer;
        }

        @Override
        public void run() {
            while(true){
                try {
                    producer.sendMessage("helloworld");
                    //Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
