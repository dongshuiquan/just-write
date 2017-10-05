package com.dsq.annotation;

import java.lang.reflect.Proxy;

/**
 * Created by DELL on 2017/10/5.
 */
public class AnimalFactory {

    public static Object getAnimalBase(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new AOPHandle(AnnoInjection.getBean(obj)));
    }
}
