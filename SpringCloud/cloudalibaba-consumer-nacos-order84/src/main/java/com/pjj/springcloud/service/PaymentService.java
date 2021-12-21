package com.pjj.springcloud.service;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import com.pjj.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 潘俊杰
 * @date 2021年11月10日 14:50
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id);
}
