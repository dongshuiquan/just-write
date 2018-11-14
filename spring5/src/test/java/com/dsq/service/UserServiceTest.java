package com.dsq.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dsq.config.SpringConfig;
import com.dsq.service.impl.Person;
import com.dsq.service.impl.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@BeforeClass
	public static void beforeClass() {
	}
	
	@Test
	public void testCount() {
		System.out.println(applicationContext.getBeanDefinitionCount());
	}
	
	
	@Test
	public void getPrint() {
		userService.print("aa");
	}
	
	@Test
	public void getPerson() {
		System.out.println(applicationContext.getBean(PersonService.class));
		System.out.println(applicationContext.getBean(Person.class));
	}
	
	@Test
	public void log() {
		userService.log("bbbbbbbbbbb");
	}
	
}
