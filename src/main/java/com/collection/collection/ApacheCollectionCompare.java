package com.collection.collection;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by vedenin on 23.10.15.
 */
public class ApacheCollectionCompare {
    // Check full equals with two collections
    @Test
    public void testContainsAll() {
        Collection<String> collection1 = Lists.newArrayList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Lists.newArrayList("a1", "a2", "a3", "a1");
        Iterable<String> iterable1 = collection1;
        Iterable<String> iterable2 = collection2;

        // Check full equals with two collections
        boolean jdk =  collection1.containsAll(collection2); // using JDK
        boolean guava = Iterables.elementsEqual(iterable1, iterable2); // using guava

        System.out.println("containsAll = " + jdk + ":" + guava ); // print containsAll = true:true:true:true
    }

    //  Check if the two collections have at least one element in common.
    @Test
    public void testContainsAny() {
        Collection<String> collection1 = Lists.newArrayList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Lists.newArrayList("a4", "a8", "a3", "a5");
        Set<String> set1 = Sets.newHashSet("a1", "a2", "a3", "a1");
        Set<String> set2 = Sets.newHashSet("a4", "a8", "a3", "a5");

        // Check if the two collections have at least one element in common.
        boolean jdk = !Collections.disjoint(collection1, collection2); // using JDK
        boolean guava = !Sets.intersection(set1, set2).isEmpty(); // using guava
        boolean apache = CollectionUtils.containsAny(collection1, collection2);  // using Apache
        System.out.println("containsAny = " + jdk + ":" + guava + ":" + apache ); // print containsAny = true:true:true:true
    }

    // Get all common elements in two collection
    @Test
    public void testIntersect() {
        Collection<String> collection1 = Lists.newArrayList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Lists.newArrayList("a4", "a8", "a3", "a5");
        Set<String> set1 = Sets.newHashSet("a1", "a2", "a3", "a1");
        Set<String> set2 = Sets.newHashSet("a4", "a8", "a3", "a5");

        // Get all common elements in two collection
        Set<String> jdk = new HashSet<>(set1); // using JDK
        jdk.retainAll(set2);
        Set<String> guava = Sets.intersection(set1, set2); // using guava
        Collection<String> apache = CollectionUtils.intersection(collection1, collection2);  // using Apache
        System.out.println("intersect = " + jdk + ":" + guava + ":" + apache + ":"); // print intersect = [a3]:[a3]:[a3]:[a3]
    }

    // Find all elements that are contained by one collecion and not contained by another (difference)
    @Test
    public void testDifference() {
        Collection<String> collection1 = Lists.newArrayList("a2", "a3");
        Collection<String> collection2 = Lists.newArrayList("a8", "a3", "a5");
        Set<String> set1 = Sets.newHashSet("a2", "a3");
        Set<String> set2 = Sets.newHashSet("a8", "a3", "a5");

        // Find all elements that are contained by one collecion and not contained by another (difference)
        Set<String> jdk = new HashSet<>(set1); // using JDK
        jdk.removeAll(set2);
        Set<String> guava = Sets.difference(set1, set2); // using guava
        Collection<String> apache = CollectionUtils.removeAll(collection1, collection2);  // using Apache
        System.out.println("difference = " + jdk + ":" + guava + ":" + apache + ":" ); // print difference = [a2]:[a2]:[a2]:[a2]
    }


    // Find symmetric difference (elements that are contained in either one collection or other but not in both
    @Test
    public void testSymmetricDifference() {
        Collection<String> collection1 = Lists.newArrayList("a2", "a3");
        Collection<String> collection2 = Lists.newArrayList("a8", "a3", "a5");
        Set<String> set1 = Sets.newHashSet("a2", "a3");
        Set<String> set2 = Sets.newHashSet("a8", "a3", "a5");

        // Find symmetric difference (elements that are contained in either one collection or other but not in both
        Set<String> intersect = new HashSet<>(set1); // using JDK
        intersect.retainAll(set2);

        Set<String> jdk = new HashSet<>(set1);
        jdk.addAll(set2);
        jdk.removeAll(intersect);

        Set<String> guava = Sets.symmetricDifference(set1, set2); // using guava
        Collection<String> apache = CollectionUtils.disjunction(collection1, collection2);  // using Apache
        System.out.println("symmetricDifference = " + jdk + ":" + guava + ":" + apache + ":"); // print symmetricDifference = [a2, a5, a8]:[a2, a5, a8]:[a2, a5, a8]:[a2, a5, a8]
    }

    // Get join two collection
    @Test
    public void testUnion() {
        Set<String> set1 = Sets.newHashSet("a1", "a2");
        Set<String> set2 = Sets.newHashSet("a4");
        Collection<String> collection1 = set1;
        Collection<String> collection2 = set2;
        // Get join two collection
        Set<String> jdk = new HashSet<>(set1); // using JDK
        jdk.addAll(set2);
        Set<String> guava = Sets.union(set1, set2); // using guava
        Collection<String> apache = CollectionUtils.union(collection1, collection2);  // using Apache
        System.out.println("union = " + jdk + ":" + guava + ":" + apache + ":"); // print union = [a1, a2, a4]:[a1, a2, a4]:[a1, a2, a4]:[a1, a2, a4]
    }

    public static void main(String[] args) {
    }
}
