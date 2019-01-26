package com.dsq.spring.aop.interceptor;

/**
 * Created by DELL on 2018/7/21.
 */
public class AfterThrowInterceptor implements Interceptor {
    @Override
    public Object invoke(Invocation invocation) {

        try {
           return invocation.process();
        } catch (Throwable t){
            afterThrow();
            throw t;
        }
    }

    public void afterThrow() {

    };
}