package com.dsq.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintBeforeAspect {

	private Logger logger = LoggerFactory.getLogger(PrintBeforeAspect.class);

	@Pointcut("execution(public * com.dsq.*.*.print(..))")
	public void action() {
		
	}
	
	
	@Before("action()") 
	public void before(JoinPoint joinPoin) {
		logger.info("PrintBeforeAspect before");
		logger.info("" + joinPoin);
	}
	
}
