package com.dsq.spring.customtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by DELL on 2018/7/14.
 */
public class UserBeanDefinationParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        System.out.println("UserBeanDefinationParser doParse");
       String id = element.getAttribute("id");
       String userName = element.getAttribute("userName");
       String email = element.getAttribute("email");
        if(StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
       if(StringUtils.hasText(userName)) {
           builder.addPropertyValue("userName", userName);
       }
       if(StringUtils.hasText(email)) {
           builder.addPropertyValue("eamil", email);
       }
    }
}
