package com.dsq.stream;

/**
 * Created by DELL on 2017/7/4.
 */
public class Dish {
    private int calories;
    private String name;

    public Dish(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "calories=" + calories +
                ", name='" + name + '\'' +
                '}';
    }
}
