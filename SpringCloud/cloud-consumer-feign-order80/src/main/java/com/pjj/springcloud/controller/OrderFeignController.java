package com.pjj.springcloud.controller;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import com.pjj.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年10月23日 12:46
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService service;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String FeignTimeout(){
        return service.FeignTimeout();
    }
}
