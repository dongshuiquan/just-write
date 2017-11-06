package com.dsq.asm;

/**
 * Created by DELL on 2017/10/27.
 */
class GrandParent {
    public void test() {
        System.out.println("test of GrandParent");
    }
}

class Parent extends GrandParent{
    public void test() {
        System.out.println("test of Parent");
    }
}

public class Son extends Parent{
    public void test() {
        System.out.println("test of Son");
    }
}