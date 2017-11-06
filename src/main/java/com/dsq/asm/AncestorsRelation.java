package com.dsq.asm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by DELL on 2017/10/28.
 */
public class AncestorsRelation {

    public static void main(String[] args) {
       new Son2().say();
    }
}

class Grandfather2{
    {
        System.out.println("grandfather");
    }
    public void say(){
        System.out.println("It's grandfather said!");
    }
}

class Father2 extends Grandfather2{
    public void say(){
        System.out.println("It's father said!");
    }
}

class Son2 extends Father2{
    public void say(){
        //如何在此处调用Grandfather的say方法
        //方法1：
        //new Grandfather().say();
        //方法2：
        //使用MethodHandle调用Grandfather的构造函数后再调用say方法
        System.out.println("It's son said!");
        //使用MethodType构造出要调用方法的返回类型
        MethodType methodType = MethodType.methodType(void.class);
        try {
            //找到祖父类的构造函数
            MethodHandle inithandle = MethodHandles.lookup().findConstructor(Grandfather2.class, methodType);
            //获取祖父类实例对象
            Object o = inithandle.invoke();
            //找到祖父类里被覆写的方法并把该方法绑定到祖父类实例上
            MethodHandle handle = MethodHandles.lookup()
                    .findVirtual(Grandfather2.class, "say", methodType).bindTo(o);
            //调用祖父类里被父类覆写的方法
            handle.invoke();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}