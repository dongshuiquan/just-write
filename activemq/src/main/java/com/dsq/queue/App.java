package com.dsq.queue;

import org.junit.Test;

/**
 * Created by dong on 2019/5/2.
 */
public class App {


    @Test
    public void producter() throws Exception {
        Producer producer = new Producer();
        producer.testMQProducerQueue();

    }

    @Test
    public void comsumer() throws Exception {
        Consumer consumer = new Consumer();
        consumer.TestMQConsumerQueue();
    }

}
