package com.dsq.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@BeforeClass
	public static void beforeClass() {
	}
	
	@Test
	public void testCount() {
		logger.info("BeanDefinitionCount : " + applicationContext.getBeanDefinitionCount());
	}
	
	
	@Test
	public void getPrint() {
		userService.print("aa");
	}
	
	@Test
	public void getPerson() {
		logger.info("PersonService : " + applicationContext.getBean(PersonService.class));
		logger.info("Person : " + applicationContext.getBean(Person.class));
	}
	
	@Test
	public void log() {
		userService.log("bbbbbbbbbbb");
	}
	
}
