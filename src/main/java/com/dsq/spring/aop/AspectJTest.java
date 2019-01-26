package com.dsq.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by DELL on 2018/7/20.
 */
@Aspect
public class AspectJTest {

    private  int count
            ;
    @Pointcut("execution(* *.test(..))")
    public void test() {}

    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest " + count++);
    }

    @After("test()")
    public void afterTest() {
        System.out.println("afterTest " + count++);
    }

    @Around("test()")
    public Object arountTest(ProceedingJoinPoint p) {
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

}
