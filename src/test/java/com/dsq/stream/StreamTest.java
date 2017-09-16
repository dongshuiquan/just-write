package com.dsq.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.*;

public class StreamTest {
    String[] contents = {"aaaaaaaaa", "aaaabb", "cccccccccd", "eeeeeed", "ffff"};
    List<String> words = Arrays.asList(contents);


    @Test
    public void filter(){
        long count = words.stream().filter(w -> w.length() > 6).count();
        count = words.parallelStream().filter(w -> w.length() > 6).count();
        System.out.println(count);
    }

    @Test
    public void createStream(){
        String contents = "i will create a stream, ok, ko";
        Stream<String> words = Stream.of(contents.split("[\\p{L}]+"));
        System.out.println(words.count());

        Stream<Double> random = Stream.generate(Math::random).limit(10);
        System.out.println(random.toArray().length);
    }

    @Test
    public void map(){
        List<String> wordList = Arrays.asList("a", "b", "c");
        Stream<String> words = wordList.stream();
        Stream<String> uppercaseWords = words.map(String::toUpperCase);
        wordList = uppercaseWords.collect(Collectors.toList());
        wordList.forEach(System.out::println);
    }
}
