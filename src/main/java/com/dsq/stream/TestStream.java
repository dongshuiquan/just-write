package com.dsq.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by DELL on 2017/7/4.
 */
public class TestStream
{

    List<Dish> menu = new ArrayList<>();
    {
        menu.add(new Dish(2,"port"));
        menu.add(new Dish(4, "beef"));
        menu.add(new Dish(3, "fries"));
        menu.add(new Dish(8, "aeason"));
        menu.add(new Dish(5, "pizza"));
        menu.add(new Dish(9, "salmon"));
    }

    @Test
    public void count(){
        long count = menu.stream().collect(Collectors.counting());
        System.out.println(count);
        count = menu.stream().count();
        System.out.println(count);
    }
    @Test
    public void maxBy(){
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        if(mostCalorieDish.isPresent()){
            System.out.println(mostCalorieDish.get());
        }
    }
    @Test
    public void avgCalories(){
        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
    }

    @Test
    public void summary(){
        IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
        System.out.println(menuStatistics.getAverage());
    }

    @Test
    public void join(){
        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(shortMenu);
        shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);
    }

    @Test
    public void genReduce(){
        int totalColories = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalColories);

        Optional<Dish> mostColories = menu.stream().collect(Collectors.reducing(
                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
        ));
        if(mostColories.isPresent()){
            System.out.println(mostColories.get());
        }
    }

    @Test
    public void test05(){
        String[] array = {"a", "b", "d", "d", "c"};
        List<String> list = Arrays.asList(array);
        list.sort(Comparator.comparing(String::hashCode));
        list.forEach(System.out::println);

        Arrays.stream(array).forEach(System.out::println);
    }
}
