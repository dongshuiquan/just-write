package com.dsq.spring.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by DELL on 2018/7/14.
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinationParser());
        registerBeanDefinitionParser("service", new UserBeanDefinationParser());
    }
}
