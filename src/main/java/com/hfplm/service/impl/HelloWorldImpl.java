package com.hfplm.service.impl;

import com.hfplm.service.HelloWorld;
import org.apache.cxf.service.invoker.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2018/6/27.
 */
@Component
public class HelloWorldImpl implements HelloWorld {


    @Override
    public void printHelloWorld(String msg) {
        System.out.println("Hello : " + msg);
    }
}
