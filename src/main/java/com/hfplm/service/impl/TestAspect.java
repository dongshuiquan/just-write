package com.hfplm.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by DELL on 2018/6/27.
 */
@Aspect
@Component
public class TestAspect {
    {
        System.out.println("TestAspectTestAspectTestAspectbbbbbb");
    }
    @Pointcut("execution(* com.hfplm.service.impl..*.*(..))")
    public void myPointCut() {
    }

    @Before("myPointCut()")
    public void myBefore() {
        System.out.println("前置通知 ： " );
    }
}