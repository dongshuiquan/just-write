package com.dsq.importtest;

import com.dsq.importtest.config.Config1;
import com.dsq.importtest.config.Config2;
import com.dsq.importtest.config.Config3;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {

    @Test
    public void import1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.getCount();
        context.close();

    }

    @Test
    public void import2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.getCount();
        context.close();
    }

    @Test
    public void import3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.getCount();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name : beanDefinitionNames) {
            System.out.println(name);
        }
        context.close();
    }
}
