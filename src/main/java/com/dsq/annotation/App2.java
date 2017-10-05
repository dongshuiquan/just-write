package com.dsq.annotation;

/**
 * Created by DELL on 2017/10/5.
 */
public class App2 {
    public static void main(String[] args) {
        AnimalInterface dog = (AnimalInterface) AnimalFactory.getAnimalBase(new DogImpl());
        System.out.println(dog.getName());
        dog.getProperty();
        dog.say();
    }
}
