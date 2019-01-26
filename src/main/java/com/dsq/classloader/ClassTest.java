package com.dsq.classloader;

/**
 * Created by DELL on 2018/8/25.
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.dsq.classloader.Demo", false, Thread.currentThread().getContextClassLoader());
        System.out.println("=============");
        Class.forName("com.dsq.classloader.Demo", true, Thread.currentThread().getContextClassLoader());
    }
}
