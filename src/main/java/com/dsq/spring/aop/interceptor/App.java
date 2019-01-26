package com.dsq.spring.aop.interceptor;

import org.junit.Test;

/**
 * Created by DELL on 2018/7/21.
 */
public class App {

    @Test
    public void test() {
        AfterInterceptor interceptor = new AfterInterceptor() {
            @Override
            public void after() {
                System.out.println("after 1");
            }
        };

        AfterInterceptor interceptor2 = new AfterInterceptor() {
            @Override
            public void after() {
                System.out.println("after 2");
            }
        };

        BeforeInterceptor interceptor3 = new BeforeInterceptor() {
            @Override
            public void before() {
                System.out.println("before 1");
            }
        };
        BeforeInterceptor interceptor4 = new BeforeInterceptor() {
            @Override
            public void before() {
                System.out.println("before 2");
            }
        };

        AfterThrowInterceptor interceptor5 = new AfterThrowInterceptor() {
            @Override
            public void afterThrow() {
                System.out.println("afterThrow 1");
            }
        };
        AfterThrowInterceptor interceptor6 = new AfterThrowInterceptor() {
            @Override
            public void afterThrow() {
                System.out.println("afterThrow 2");
            }
        };

        Target target = new Target();
        Invocation invocation = new Invocation(target);
        invocation.addInterceptor(interceptor);
        invocation.addInterceptor(interceptor2);
        invocation.addInterceptor(interceptor3);
        invocation.addInterceptor(interceptor4);
        invocation.addInterceptor(interceptor5);
        invocation.addInterceptor(interceptor6);
        Object result = invocation.process();
        System.out.println(result);
    }
}
