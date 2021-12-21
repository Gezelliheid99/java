package com.pjj.boot;

import com.pjj.boot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootApplication.class, args);
    }

}
