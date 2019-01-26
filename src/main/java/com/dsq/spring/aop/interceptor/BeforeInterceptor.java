package com.dsq.spring.aop.interceptor;



/**
 * Created by DELL on 2018/7/21.
 */
public  class BeforeInterceptor implements Interceptor {
    @Override
    public Object invoke(Invocation invocation) {
        before();
         return  invocation.process();
    }

    public  void before(){
    };
}
