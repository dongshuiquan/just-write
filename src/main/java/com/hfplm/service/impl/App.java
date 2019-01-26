package com.hfplm.service.impl;

import com.hfplm.service.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2018/6/27.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext-client.xml");
        System.out.println(context.getBeanDefinitionCount());
        HelloWorld helloWorld = context.getBean( HelloWorld.class);
        helloWorld.printHelloWorld("aa");
    }

}
