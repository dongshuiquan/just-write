package com.dsq.guava.math;

import com.google.common.math.BigIntegerMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import org.junit.Assert;
import org.junit.Test;

import java.math.RoundingMode;

public class MathTest {
    @Test
    public void test01(){
        int z = IntMath.divide(7, 3, RoundingMode.HALF_DOWN);
        System.out.println(z);
        z = IntMath.divide(7, 3, RoundingMode.HALF_UP);
        System.out.println(z);
        z = IntMath.divide(7, 3, RoundingMode.HALF_EVEN);
        System.out.println(z);
    }

    @Test
    public void test02(){
        long z = LongMath.divide(7, 3, RoundingMode.HALF_DOWN);
        System.out.println(z);
        z = LongMath.divide(7, 3, RoundingMode.HALF_UP);
        System.out.println(z);
        z = LongMath.divide(7, 3, RoundingMode.HALF_EVEN);
        System.out.println(z);
    }

   @Test
   public void test03(){
        int a = IntMath.log2(1000, RoundingMode.HALF_DOWN);
        System.out.println(a);
        a = IntMath.log2(1000, RoundingMode.HALF_UP);
        System.out.println(a);

        long b = LongMath.log2(1000L, RoundingMode.HALF_DOWN);
        System.out.println(b);
   }

   @Test
    public void testGcd(){
       int a = IntMath.gcd(12, 18);
       Assert.assertEquals(6, a);

       long b = LongMath.gcd(12, 18);
       System.out.println(b);
       Assert.assertEquals(6, b);
   }

   @Test
    public  void testPow(){
        int a= IntMath.pow(3, 2);
        Assert.assertEquals(9, a);

       long b = LongMath.pow(3, 3);
       Assert.assertEquals(27, b);
   }

   @Test
    public void testFact(){
        int a = IntMath.factorial(5);
        Assert.assertEquals(120, a);

        long b = LongMath.factorial(5);
        Assert.assertEquals(120, b);
   }
}
