package com.dsq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.dsq")
@EnableAspectJAutoProxy
public class SpringConfig {
	

}
