package com.dsq.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * Created by dong on 2019/3/30.
 */
public class BeanConfig {
    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }


    @Bean
    //创建这个bean的必要条件,matches方法必须为true才会注册bean，反之忽略bean。
    //扫描到bean立刻调用，不会等配置类中的所有bean都注册好之后再调用，因此Cat bean写前面，写后面会出错。
    @Conditional({PetCondition.class})
    public Dog createDog(){
        return new Dog();
    }

}
