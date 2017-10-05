package com.dsq.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by DELL on 2017/10/5.
 */
public class AOPHandle implements InvocationHandler {
    private Object target;

    public AOPHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }
}
