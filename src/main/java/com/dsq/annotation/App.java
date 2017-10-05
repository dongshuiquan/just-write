package com.dsq.annotation;

/**
 * Created by DELL on 2017/10/5.
 */
public class App {
    public static void main(String[] args) {
        DogImpl dog = new DogImpl();
        System.out.println(dog.getName());
        dog.getProperty();
    }
}
