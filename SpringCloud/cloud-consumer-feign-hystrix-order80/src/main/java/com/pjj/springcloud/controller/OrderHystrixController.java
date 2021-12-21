package com.pjj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pjj.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年10月24日 12:35
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService service;

    @GetMapping("/hystrix/ok/{id}")
    String PaymentInfo_ok(@PathVariable("id") Integer id){
        return service.PaymentInfo_ok(id);
    }


    @GetMapping("/hystrix/timeout")
    // @HystrixCommand
    public String paymentInfo_Timeout(){
        // int a = 10/0;
        return service.paymentInfo_Timeout();
    }

    public String paymentInfoTimeoutHandler(){
        return "我是消费者80，程序运行出错或者自行检查错误，请稍后再试！";
    }

    public String payment_Global_FallbackMethod(){
        return "程序运行出错啦~请稍后再试！";
    }
}
