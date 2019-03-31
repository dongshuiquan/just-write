package com.dsq.condition;

/**
 * Created by dong on 2019/3/30.
 */
public class Animal {
    private String name;

    public String getName() {
        return getClass().getName();
    }

    public void setName(String name) {
        this.name = name;
    }

}
