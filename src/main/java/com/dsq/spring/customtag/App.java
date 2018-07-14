package com.dsq.spring.customtag;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by DELL on 2018/7/14.
 */
public class App {

    @Test
    public void testCustomTag() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/dsq/spring/customtag/user.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
