package com.dsq.guava.guava;

import com.google.common.base.Optional;
import com.google.common.math.DoubleMath;
import org.junit.Test;



public class GuavaTest {
    @Test
    public void testOptional(){
        Optional o  =  Optional.of(5);
        System.out.println(o.get());
    }

    @Test
    public void testMath(){
        System.out.println(DoubleMath.isMathematicalInteger(1.00));
    }
}
