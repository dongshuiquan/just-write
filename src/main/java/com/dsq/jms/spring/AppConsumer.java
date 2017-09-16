package com.dsq.jms.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2017/9/16.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:jms/consumer.xml");
    }
}
