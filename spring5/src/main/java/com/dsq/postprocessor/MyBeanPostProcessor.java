package com.dsq.postprocessor;

import com.dsq.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info(beanName + " : " + bean);
		if(bean instanceof LogService) {
			throw new RuntimeException();
		}
		return bean;
	}
}
