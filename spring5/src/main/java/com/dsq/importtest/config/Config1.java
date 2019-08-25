package com.dsq.importtest.config;

import com.dsq.importtest.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(value = UserServiceImpl.class)
public class Config1 {
}
