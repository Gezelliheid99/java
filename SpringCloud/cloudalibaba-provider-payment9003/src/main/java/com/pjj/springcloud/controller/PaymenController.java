package com.pjj.springcloud.controller;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘俊杰
 * @date 2021年11月09日 21:49
 */
@RestController
public class PaymenController {
    @Value("${server.port}")
    private String serverPort;
    public static HashMap<Integer, Payment> map = new HashMap<>();
    static {
        map.put(1, new Payment(1,"111111111111"));
        map.put(2, new Payment(2,"222222222222"));
        map.put(3, new Payment(3,"333333333333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id){
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult(200, "server port:" + serverPort, payment);
        return result;
    }
}
