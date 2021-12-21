package com.pjj.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author 98334
 */
@SpringBootConfiguration
@EnableAutoConfiguration(exclude = RedisAutoConfiguration.class)
@ComponentScan(value = "com.pjj.boot")
@MapperScan(value = "com.pjj.boot.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
