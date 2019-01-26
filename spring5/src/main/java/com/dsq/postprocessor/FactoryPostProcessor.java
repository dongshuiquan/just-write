package com.dsq.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class FactoryPostProcessor implements BeanFactoryPostProcessor {

	private Logger logger = LoggerFactory.getLogger(FactoryPostProcessor.class);

	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
			throws BeansException {
		logger.info("******BeanFactoryPostProcessor");
		String[] beanStr = configurableListableBeanFactory.getBeanDefinitionNames();
		for (String beanName : beanStr) {
			
			logger.info(beanName);
			if(beanName.equals("userServiceImpl")) {
				 BeanDefinition beanDefinition = configurableListableBeanFactory
	                        .getBeanDefinition(beanName);
	                MutablePropertyValues m = beanDefinition.getPropertyValues();
                    m.addPropertyValue("username", "lisi");
                    logger.info("change username");
			}
		}
	}
}
