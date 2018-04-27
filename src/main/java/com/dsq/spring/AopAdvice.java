package com.dsq.spring;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by DELL on 2018/4/28.
 */
public class AopAdvice implements MethodBeforeAdvice {

    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("before mothod");
    }
}