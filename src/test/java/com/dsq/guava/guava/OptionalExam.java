package com.dsq.guava.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DELL on 2017/11/11.
 */
public class OptionalExam {

    @Test
    public void of() {
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());
    }

    @Test
    public void absent() {
        Optional<Integer> possible = Optional.absent();
        System.out.println(possible.isPresent());
    }

    @Test
    public void fromNullable() {
        Object object = null;
        Optional<Object> possible = Optional.fromNullable(object);
        System.out.println(possible.isPresent());
    }

    @Test
    public void isPresent() {

    }

    @Test(expected = IllegalStateException.class)
    public void get() {
        Optional<String> possible = Optional.of("hello");
        if(possible.isPresent()) {
            System.out.println(possible.get());
        }
        possible = Optional.absent();
        System.out.println(possible.get());
        System.out.println("ok");
    }

    @Test
    public void or() {
        Optional<String> possible = Optional.absent();
        System.out.println(possible.or("world"));
    }

    @Test
    public void orNull() {
        Optional<String> possible = Optional.absent();
        System.out.println(possible.orNull());
    }

    @Test
    public void asSet() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        Optional<Set> possible = Optional.of(set);
        Set set2 = possible.asSet();
        System.out.println(set2);
    }

    @Test
    public void empty() {
        Optional<String> possible = Optional.of("");
        System.out.println();
    }

}
