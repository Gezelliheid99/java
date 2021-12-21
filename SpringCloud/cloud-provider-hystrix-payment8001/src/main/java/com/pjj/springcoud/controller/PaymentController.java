package com.pjj.springcoud.controller;

import com.pjj.springcoud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年10月23日 22:00
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        String result = service.paymentInfo_Ok(id);
        log.error(result);
        return result;
    }

    @GetMapping("/hystrix/timeout")
    public String paymentInfo_Timeout(){
        String result = service.paymentInfo_Timeout();
        log.error(result);
        return result;
    }

    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = service.paymentCircuitBreaker(id);
        log.info("result：" + result);
        return result;
    }

















}
