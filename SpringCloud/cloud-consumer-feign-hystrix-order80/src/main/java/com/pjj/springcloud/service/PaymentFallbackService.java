package com.pjj.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 潘俊杰
 * @date 2021年10月24日 15:30
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String PaymentInfo_ok(Integer id) {
        return "xxxxxxxx  PaymentInfo_ok 运行异常";
    }

    @Override
    public String paymentInfo_Timeout() {
        return "xxxxxxxx  paymentInfo_Timeout 运行异常";
    }
}
