package com.dsq.jms.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2017/9/16.
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:jms/producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for(int i = 0; i < 100; i++) {
            service.sendMessage("test" + i);
        }
        context.close();
    }
}
