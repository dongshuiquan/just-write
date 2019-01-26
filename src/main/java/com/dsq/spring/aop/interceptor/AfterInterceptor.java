package com.dsq.spring.aop.interceptor;

/**
 * Created by DELL on 2018/7/21.
 */
public class AfterInterceptor implements Interceptor {
    @Override
    public Object invoke(Invocation invocation) {

       try {
          return invocation.process();
       } finally {
           after();
       }


    }

    public void after() {

    };
}
