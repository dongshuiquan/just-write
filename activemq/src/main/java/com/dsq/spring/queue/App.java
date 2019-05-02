package com.dsq.spring.queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dong on 2019/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-jms-producer.xml")
public class App {

    @Autowired
    private QueueProducer queueProducer;

    @Test
    public void testSend(){

        queueProducer.sendTextMessage("SpringJms-点对点");
    }
}