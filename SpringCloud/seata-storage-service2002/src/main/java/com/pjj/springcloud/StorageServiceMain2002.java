package com.pjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 潘俊杰
 * @date 2021年11月14日 18:46
 */
@SpringBootApplication
@EnableFeignClients
public class StorageServiceMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StorageServiceMain2002.class, args);
    }
}
