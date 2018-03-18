package com.dsq.rpc;

/**
 * Created by DELL on 2018/3/18.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
