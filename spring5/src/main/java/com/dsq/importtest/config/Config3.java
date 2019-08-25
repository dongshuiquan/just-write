package com.dsq.importtest.config;

import com.dsq.importtest.EnableUserService;
import com.dsq.importtest.UserServiceBeanDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



//@Configuration()
@EnableUserService(name="ivan_test")
public class Config3 {

}

