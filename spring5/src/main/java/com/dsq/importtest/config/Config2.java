package com.dsq.importtest.config;

import com.dsq.importtest.UserServiceBeanDefinitionRegistrar;
import com.dsq.importtest.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



//@Configuration(value="ivan_test")
@Import(value={UserServiceBeanDefinitionRegistrar.class})
public class Config2 {
}
