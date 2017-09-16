package com.dsq.lambda;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

/**
 * Created by DELL on 2017/7/3.
 */
public class AppleWeight {
    private List<Apple> list = new ArrayList<>();
    {
        list.add(new Apple(3));
        list.add(new Apple(2));
        list.add(new Apple(7));
        list.add(new Apple(5));
    }

    @Test
    public void test01(){
       Collections.sort(list, new Comparator<Apple>() {
           @Override
           public int compare(Apple o1, Apple o2) {
               return o1.getWeight() - o2.getWeight();
           }
       });
    }

    @Test
    public void test02(){
        Collections.sort(list, (a, b) -> a.getWeight() - b.getWeight());
    }

    @Test
    public void test03(){
        Collections.sort(list, comparing((a) -> a.getWeight()));
    }

    @Test
    public void test04(){
        Collections.sort(list, comparing(Apple::getWeight));
    }

    @Test
    public void test05(){
        list.sort(comparing(Apple::getWeight).reversed());
    }
    @After
    public void after(){
        list.forEach(System.out::println);
    }

}

class Apple{
    private int weight;

    public Apple(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
