package com.dsq.proxy;

import java.lang.reflect.Method;

/**
 * Created by dong on 2018/5/20.
 */
public interface InvocationHandler
{
    void invoke(Object proxy, Method method) throws Exception;
}