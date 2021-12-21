package com.pjj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import com.pjj.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年11月09日 22:14
 */
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService service;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable("id") Integer id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException 非法参数");
        } else if (result.getData() == null){
            throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable Integer id,Throwable exception){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "fallback" + exception.getMessage(), payment);
    }
    public CommonResult<Payment> blockHandler(@PathVariable Integer id, BlockException exception){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(440, "blockHandler" + exception.getMessage(), payment);
    }

    @GetMapping("consumer/openFeign/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id){
        return service.paymentSQL(id);
    }

}
