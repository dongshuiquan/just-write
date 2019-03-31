package com.dsq.condition;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by dong on 2019/3/30.
 */
public class MyTest {

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Person person = (Person)context.getBean("person");
        System.out.println("person.getAnimal().getName() " + person.getAnimal().getName());

    }
}
