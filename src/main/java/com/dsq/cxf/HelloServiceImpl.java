package com.dsq.cxf;

/**
 * Created by DELL on 2018/4/1.
 */
public class HelloServiceImpl implements HelloService{


    @Override
    public String say(String name) {
        return "hello " + name;
    }
}
