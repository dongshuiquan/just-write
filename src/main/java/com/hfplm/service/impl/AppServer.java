package com.hfplm.service.impl;

import com.hfplm.service.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by DELL on 2018/6/27.
 */
public class AppServer {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext-server.xml");
        System.out.println(context.getBeanDefinitionCount());
        HelloWorld helloWorld = context.getBean( HelloWorld.class);
        helloWorld.printHelloWorld("aa");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
