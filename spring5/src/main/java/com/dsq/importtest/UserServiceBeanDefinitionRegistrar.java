package com.dsq.importtest;


import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class UserServiceBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder userService = BeanDefinitionBuilder.rootBeanDefinition(UserServiceImpl.class);
        //通过registry就可以注入到容器里啦
        registry.registerBeanDefinition("userService", userService.getBeanDefinition());
    }

}
