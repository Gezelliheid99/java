package com.pjj.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潘俊杰
 * @date 2021年10月23日 13:41
 */
@Configuration
public class FeignConfiguration {
    @Bean
    Logger.Level FeignLogLevel(){
        return Logger.Level.FULL;
    }
}
