package com.dsq.java.lang;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by DELL on 2017/7/15.
 */
public class StringTest {

    @Test
    public void comparator(){
        String[] arr  = {"1", "1.0", "1.1","1.1.0", "1.1.1", "1.1.2", "1.2", "1.2.1", "1.9", "2.0"};
        for(String s : arr){
            System.out.println(s.compareTo("1.1.0"));
        }
    }

    @Test
    public void comparator2(){
        Stream<String> arr  = Stream.of("1", "1.0", "1.1","1.1.0", "1.1.1", "1.1.2", "1.2", "1.2.1", "1.9", "2.0");
        arr.map(s ->s.compareTo("1.1.0")).forEach(System.out::println);
    }

    @Test
    public void match(){
        System.out.println("abc".matches("^a\\w+$"));
    }

    @Test(expected = NullPointerException.class)
    public void isEmply(){
        String s = null;
        System.out.println(s.isEmpty());
    }
}
