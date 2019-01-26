package com.dsq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsq.service.LogService;
import com.dsq.service.UserService;

@Service
public class LogServiceImpl implements LogService{

	Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
	
	@Autowired
	private UserService userService;
	
	public void log(String message) {
		logger.info(message);
	}

}
