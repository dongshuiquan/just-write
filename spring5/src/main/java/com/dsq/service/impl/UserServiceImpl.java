package com.dsq.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsq.service.LogService;
import com.dsq.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private String username;
	
	@Autowired
	private LogService logService;
	
	public void print(String name) {
		logger.info(name);
		logger.info(username);
	}


	public void log(String message) {
		logService.log(message);
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}

}
