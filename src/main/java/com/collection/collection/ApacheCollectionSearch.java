package com.collection.collection;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Testing search method using guava, apache, jdk, gs
 *
 *
 * Created by vedenin on 17 .10.15.
 */
public class ApacheCollectionSearch {
    // Get frequency element in collection
    @Test
    public  void testCount() {
        Collection<String> collection = Lists.newArrayList("a1", "a2", "a3", "a1");
        Iterable<String> iterable = collection;

        // Get frequency element in collection
        int i1 = Iterables.frequency(iterable, "a1"); // using guava
        int i2 = Collections.frequency(collection, "a1"); // using JDK
        long i5 = collection.stream().filter("a1"::equals).count(); // using stream JDK

        System.out.println("count = " + i1 + ":" + i2 + ":" +  ":" + i5); // print count = 2:2:2:2:2
    }

    // get first element
    @Test
    public  void testGetFirst() {
        Collection<String> collection = Lists.newArrayList("a1", "a2", "a3", "a1");
        Iterable<String> iterable = collection;

        // get first element
        Iterator<String> iterator = collection.iterator(); // using JDK
        String jdk = iterator.hasNext() ? iterator.next(): "1";
        String guava = Iterables.getFirst(iterable, "1"); // using guava
        String stream = collection.stream().findFirst().orElse("1"); // using Stream API
        System.out.println("first = " + jdk + ":" + guava + ":" + ":" + stream); // print first = a1:a1:a1:a1:a1
    }

    // get last element
    @Test
    public  void testGetLast() {
        Collection<String> collection = Lists.newArrayList("a1", "a2", "a3", "a8");
        Iterable<String> iterable = collection;

        // get last element
        Iterator<String> iterator = collection.iterator(); // using JDK
        String jdk = "1";
        while(iterator.hasNext()) {
            jdk = iterator.next();
        }
        String guava = Iterables.getLast(iterable, "1"); // using guava
        String stream = collection.stream().skip(collection.size()-1).findFirst().orElse("1"); // using Stream API
        System.out.println("last = " + jdk + ":" + guava + ":" + ":" + stream); // print last = a8:a8:a8:a8:a8
    }

    // get a element, if collection has only one element
    @Test
    public  void testGetSingle() {
        Collection<String> collection = Lists.newArrayList("a3");
        Iterable<String> iterable = collection;

        // get a element, if collection has only one element
        String guava = Iterables.getOnlyElement(iterable); // using guava
        String jdk = collection.iterator().next(); // using JDK

        System.out.println("single = " + jdk + ":" + guava + ":" ); // print single = a3:a3:a3:a3
    }

    // get max element
    @Test
    public   void testGetMax() {
        Collection<String> collection = Lists.newArrayList("5", "1", "3", "8", "4");
        Iterable<String> iterable = collection;

        // get max element
        String jdk = Collections.max(collection); // using JDK
        String guava = Ordering.natural().max(iterable); // using guava

        System.out.println("max = " + jdk + ":" + guava + ":" ); // print max = 8:8:8
    }

    // get min element
    @Test
    public   void testGetMin() {
        Collection<String> collection = Lists.newArrayList("5", "1", "3", "8", "4");
        Iterable<String> iterable = collection;

        // get min element
        String jdk = Collections.min(collection); // using JDK
        String guava = Ordering.natural().min(iterable); // using guava
        System.out.println("min = " + jdk + ":" + guava + ":"); // print min = 1:1:1
    }

    // find element in sorted list
    @Test
    public void testBinarySearch() {
        List<String> list = Lists.newArrayList("2", "4", "13", "31", "43");

        // find element in sorted list
        int jdk = Collections.binarySearch(list, "13");
        int guava = Ordering.natural().binarySearch(list, "13");

        System.out.println("find = " + jdk + ":" + guava + ":" ); // print find = 2:2:2
    }

    // find element in unsorted collection
    @Test
    public  void testSearch() {
        Collection<String> collection = Lists.newArrayList("2", "14", "3", "13", "43");
        Iterable<String> iterable = collection;

        // find element in unsorted collection
        String jdk = collection.stream().filter("13"::equals).findFirst().get();
        String guava = Iterables.find(iterable, "13"::equals);

        System.out.println("find = " + jdk + ":" + guava + ":" ); // print find = 13:13:13:13
    }

    // get third element
    @Test
    public  void testGetByIndex() {
        Collection<String> collection = Lists.newArrayList("a1", "a2", "a3", "a1");
        Iterable<String> iterable = collection;

        // get third element
        String jdk = collection.stream().skip(2).findFirst().get(); // using JDK
        String guava = Iterables.get(iterable, 2); // using guava
        System.out.println("third = " + jdk + ":" + guava + ":" ); // print third = a3:a3:a3
    }

    // find all elements using pattern
    @Test
    public void testSelect() {
        Collection<String> collection = Lists.newArrayList("2", "14", "3", "13", "43");
        Iterable<String> iterable = collection;

        // find all elements using pattern
        List<String> jdk = collection.stream().filter((s) -> s.contains("1")).collect(Collectors.toList()); // using JDK
        Iterable<String>  guava = Iterables.filter(iterable, (s) -> s.contains("1")); // using guava

        System.out.println("select = " + jdk + ":" + guava + ":" ); // print select = [14, 13]:[14, 13]:[14, 13]:[14, 13]
    }

    public static void main(String[] args) {
    }

}
