package com.dsq.service.impl;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class PersonService implements FactoryBean<Person>{

	public Person getObject() throws Exception {
		Person person =  new Person();
		person.setId("1");
		person.setEmail("qwer@123.com");
		return person;
	}

	public Class<?> getObjectType() {
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}


}
