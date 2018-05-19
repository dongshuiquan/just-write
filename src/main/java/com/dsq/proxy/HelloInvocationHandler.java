package com.dsq.proxy;

import java.lang.reflect.Method;

/**
 * Created by dong on 2018/5/20.
 */
public class HelloInvocationHandler implements InvocationHandler
{
    private Object obj;

    public HelloInvocationHandler(Object obj)
    {
        this.obj = obj;
    }


    @Override
    public void invoke(Object proxy, Method method) throws Exception {
        System.out.println("Before Hello World!");
        try
        {
            method.invoke(obj, new Object[]{});
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("After Hello World!");
    }
}