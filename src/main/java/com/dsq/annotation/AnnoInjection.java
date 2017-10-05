package com.dsq.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by DELL on 2017/10/5.
 */
public class AnnoInjection {

    public static Object getBean(Object obj) {
        try {

            // 获取属性注解
            Field[] f = obj.getClass().getDeclaredFields();
            for(Field ff : f) {
                Seven s = ff.getAnnotation(Seven.class);
                if(s != null) {
                    System.out.println("注入" + ff.getName() +"属性 : " + s.value());
                    obj.getClass()
                            .getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
                                new Class[]{String.class})
                            .invoke(obj, s.value());
                }
            }

            // 获取方法注解
            Method[] methods = obj.getClass().getDeclaredMethods();
            for(Method m : methods) {
                Seven s = m.getDeclaredAnnotation(Seven.class);
                if(s != null) {
                    System.out.println("注入" + m.getName() + "方法 : " + s.Property());
                    m.invoke(obj, s.Property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
