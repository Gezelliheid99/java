package com.pjj.springcloud.service.impl;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import com.pjj.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author 潘俊杰
 * @date 2021年11月10日 14:53
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Integer id) {
        return new CommonResult<>(444, "服务降级返回", new Payment(id,"errorSerial"));
    }
}
