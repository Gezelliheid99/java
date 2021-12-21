package com.pjj.config;

import com.pjj.pojo.Pet;
import com.pjj.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潘俊杰
 * @date 2021年09月15日 17:36
 */
@Configuration
@ConditionalOnBean(name = "userzs")
public class MyConfig {


    @Bean("userzs")
    public User user(){
        return new User("张三", "男");
    }

    @Bean
    public Pet pet(){
        return new Pet("lucky",5);
    }


}
