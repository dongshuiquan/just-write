package com.dsq.extend;

/**
 * Created by dong on 2019/3/27.
 */
public class A {

    public A getA() {
        return new A();
    }
}

class B extends A{

    @Override
    public B getA() {
        return new B();
    }
}