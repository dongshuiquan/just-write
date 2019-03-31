package com.dsq.condition;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dong on 2019/3/30.
 */
public class Person {
    private String name;

    @Autowired
    private  Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
