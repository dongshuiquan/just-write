package com.dsq.lambda;

import org.junit.Test;

import javax.sql.rowset.serial.SerialStruct;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by DELL on 2017/7/3.
 */
public class Letter {

    public static String addHeader(String text){
        return "From Dong, Shui And Quan: " + text;
    }

    public static String addFooter(String text){
        return text + " King regards";
    }

    public static String checkSpell(String text){
        return text.replace("labda", "lambda");
    }

    @Test
    public void test(){
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformmationPipeline = addHeader.andThen(Letter::checkSpell)
                .andThen(Letter::addFooter);
        String result = transformmationPipeline.apply("it is a labda test.");
        System.out.println(result);
    }

    @Test
    public void test02(){
        Function<String, Integer>  strToInt = Integer::parseInt;
        int num =  strToInt.apply("123");
        System.out.println(num);


    }

    @Test
    public void test03(){
        Consumer consumer = System.out::println;
        consumer.accept(1234);

    }

    @Test
    public void test04(){
        Predicate<String> predicate = String::isEmpty;
        boolean flag = predicate.test("");
    }
}
