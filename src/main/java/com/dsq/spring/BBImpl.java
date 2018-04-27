package com.dsq.spring;

/**
 * Created by DELL on 2018/4/28.
 */
public class BBImpl implements BB {
    @Override
    public String hello() {
        return "bb hello";
    }

    @Override
    public void hi() {
        System.out.println("bb hihihi");
    }
}
