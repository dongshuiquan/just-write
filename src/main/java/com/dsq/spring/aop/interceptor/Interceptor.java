package com.dsq.spring.aop.interceptor;


/**
 * Created by DELL on 2018/7/21.
 */
public interface Interceptor {
    Object invoke(Invocation invocation);
}
