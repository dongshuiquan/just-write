package com.dsq.javassist;

/**
 * Created by DELL on 2018/9/25.
 */
public class App {

    public static void main(String[] args) {
        TCModifier.modify();
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.test();
        helloWorld.test();
    }

}
