package com.dsq.topic;


import org.junit.Test;

/**
 * Created by dong on 2019/5/2.
 */
public class App {


    @Test
    public void producer() throws Exception {
        Producer producer = new Producer();
        producer.testTopicProducer();

    }

    @Test
    public void comsumer() throws Exception {
        Consumer consumer = new Consumer();
        consumer.TestTopicConsumer();

    }

}
