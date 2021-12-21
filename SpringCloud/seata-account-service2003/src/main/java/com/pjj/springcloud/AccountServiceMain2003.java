package com.pjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 潘俊杰
 * @date 2021年11月15日 21:13
 */
@SpringBootApplication
@EnableFeignClients
public class AccountServiceMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceMain2003.class, args);
    }
}
