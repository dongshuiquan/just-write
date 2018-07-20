package com.dsq.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2018/7/20.
 */
public class App {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aop/aspectjTest.xml"); // classpath:com/dsq/spring/aop/aspectjTest.xml


        TestInterface testBean = context.getBean(TestInterface.class);
        testBean.test();
    }


}
