package com.dsq.spring.aop;

/**
 * Created by DELL on 2018/7/20.
 */
public class TestBean implements TestInterface{
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("test");
    }
}
