package com.dsq.guava.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import org.junit.Test;

/**
 * Created by DELL on 2017/11/12.
 */
public class ObjectExam {

    @Test
    public void equals() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }

    @Test
    public void hashCodeTest() {
        System.out.println(Objects.hashCode("a", "b"));
    }

    @Test
    public void toStringTest() {
        System.out.println(MoreObjects.toStringHelper(this.getClass()).add("name", "dong").toString());
    }
    @Test
    public void compareTo() {
        System.out.println(ComparisonChain.start()
        .compare("a", "a")
        .compare(1, 2)
                .result()
        );
    }
}
