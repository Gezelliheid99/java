package com.pjj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pjj.springcloud.handler.CustomerBlockHandler;
import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘俊杰
 * @date 2021年11月09日 20:50
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名称限流测试", new Payment(111, "serial111"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/byResource/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按URL限流测试", new Payment(222, "serial222"));
    }

    @GetMapping("/byResource/CustomerHandler")
    @SentinelResource(value = "CustomerHandler",
                      blockHandlerClass = CustomerBlockHandler.class,
                      blockHandler = "CustomerHandler2")
    public CommonResult CustomerHandler(){
        return new CommonResult(200, "按用户自定义方法", new Payment(333, "serial333"));
    }

}
