package com.dsq.javassist;

import javassist.*;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by DELL on 2018/10/31.
 */
public class TestJavaAsssist02 {

    /**
     * 测试简单方法
     */
    @Test
    public void test01() {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("com.dsq.javassist.HelloWorld");
            byte[] bytes = cc.toBytecode();
            System.out.println(Arrays.toString(bytes));
            System.out.println(cc.getName());
            System.out.println(cc.getSimpleName());
            System.out.println(cc.getSuperclass());
            System.out.println(cc.getInterfaces());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试产生新的方法
     */
    @Test
    public void test02() {
        ClassPool pool = ClassPool.getDefault();

        try {
            CtClass cc = pool.get("com.dsq.javassist.HelloWorld");
            // CtMethod m =CtNewMethod.make("public int add(int a,int b){return a+b;}",cc);
            CtMethod m = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, cc);
            m.setModifiers(Modifier.PUBLIC);
            //m.setBody("{System.out.println(\"www.sxt.cn\");return a+b;}");
            m.setBody("{System.out.println(\"www.sxt.cn\");return $1+$2;}");
            cc.addMethod(m);
            //通过反射机制调用新生成的方法
            Class clazz = cc.toClass();
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("add", int.class, int.class);
            Object result = method.invoke(obj, 200, 300);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改已经有的方法的信息
     */
    @Test
    public void test03() {
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("com.dsq.javassist.HelloWorld");
            CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
            cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
            cm.insertAfter("System.out.println(\"end!!!\");");

            //通过反射调用新生成的方法
            Class clazz = cc.toClass();
            Object obj = clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
            Method method = clazz.getDeclaredMethod("sayHello", int.class);
            method.setAccessible(true);
            Object result = method.invoke(obj, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 调用构造器
     */
    @Test
    public void test05(){
        ClassPool pool =ClassPool.getDefault();
        try {
            CtClass cc=pool.get("com.dsq.javassist.HelloWorld");
            CtConstructor[] constructor=cc.getConstructors();
            for(CtConstructor stor:constructor){
                System.out.println(stor);
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}