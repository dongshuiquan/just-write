package com.dsq.extend;

/**
 * Created by dong on 2019/3/27.
 */
public class A {

    public A getA() {
        return new A();
    }


    public static void main(String[] args) {
       /* int #a = 1;
        String ~f=  "";
        String !g = "";
        String @h = "";*/


        String _b = "";
        Double c = 2.1;
        double d = 2.1;
        String $e = "";



    }
}

class B extends A{

    @Override
    public B getA() {
        return new B();
    }
}