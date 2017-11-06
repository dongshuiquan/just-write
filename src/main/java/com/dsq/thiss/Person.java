package com.dsq.thiss;

/**
 * Created by DELL on 2017/10/27.
 */
public class Person {

    public void say() {
        System.out.println("person method");
    }

    public void test() {
        int i = 0;
        while(i++ < 3) {
            Person.this.say();
        }
    }
}
