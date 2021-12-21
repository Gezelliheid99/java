package com.pjj.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 潘俊杰
 * @date 2021年10月24日 12:32
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String PaymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout")
    String paymentInfo_Timeout();
}
