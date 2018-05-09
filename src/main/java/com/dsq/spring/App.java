package com.dsq.spring;

import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by DELL on 2018/4/28.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(context.getBeanDefinitionCount());
        UserService userService = context.getBean("userServiceAop", UserService.class);
        userService.hello();
        System.out.println(userService instanceof Advised);
        Advised advised = (Advised) userService;
        System.out.println(advised.getTargetSource());
    }

    @Test
    public  void testCast() {
        UserServiceImpl userService = new UserServiceImpl();
        BB bb = (BB) userService;
    }

    @Test
    public  void testCast2() {
        UserService userService = new UserServiceImpl();
        BB bb = new BBImpl();
        BB bb1 = (BB) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{BB.class, UserService.class}, new MyInvocationHandler(bb, userService));
        bb1.hi();
        System.out.println(bb1.hello());

        UserService u = (UserService) bb1;
        System.out.println(u.addUser("aa"));
        System.out.println(u.addUser(5));
        System.out.println(u.hello());
    }
}

    class MyInvocationHandler implements InvocationHandler{
        Object[] targets;

        public MyInvocationHandler(Object ... targets) {
            this.targets = targets;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();
            //System.out.println(name);
            //System.out.println(Arrays.asList(targets));
            List<Class<?>> argsClasses = new ArrayList<>();
            if(args != null) {
                for(Object arg : args) {
                    argsClasses.add(arg.getClass());
                }
            }
            Class[] argsClass = argsClasses.toArray(new Class[0]);
            for(Object target : targets) {
                Method[] methods = target.getClass().getDeclaredMethods();
                for(Method m : methods) {

                    if(m.getName().equals(name) ) {
                        System.out.println(Arrays.toString(m.getParameterTypes()));
                        System.out.println(Arrays.toString(argsClass));
                        System.out.println(Objects.equals(argsClass, m.getParameterTypes()));
                        if(m.getParameterCount() == argsClass.length) {
                            boolean flag = true;
                            Class<?>[] parameterTypes = m.getParameterTypes();
                            for(int i = 0; i < parameterTypes.length; i++) {

                                // TODO int.class Integer.class
                                if(!parameterTypes[i].equals(argsClass[i])) {
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag) {
                                return method.invoke(target, args);
                            }
                        }
                        //return method.invoke(target, args);
                    }
                }

            }
            return null;
        }
    }