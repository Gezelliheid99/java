package com.pjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 潘俊杰
 * @date 2021年10月29日 13:51
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderMain8801.class,args);
    }
}
