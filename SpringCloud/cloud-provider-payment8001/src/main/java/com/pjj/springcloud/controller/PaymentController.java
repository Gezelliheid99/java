package com.pjj.springcloud.controller;

import com.pjj.springcloud.pojo.CommonResult;
import com.pjj.springcloud.pojo.Payment;
import com.pjj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author 潘俊杰
 * @date 2021年10月16日 21:38
 */
@Slf4j
@RestController
@SuppressWarnings("unchecked")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/insert")
    public CommonResult insertPay(@RequestBody Payment payment){
        boolean result = service.save(payment);
        log.info("*******插入成功：" + result);
        if (result){
            return new CommonResult(200, "添加成功！ serverPort:" + serverPort,result);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPay(@PathVariable("id") Long id){
        Payment result = service.getById(id);
        log.info("*******查询成功：" + result);
        if (result != null){
            return new CommonResult(200, "查询成功！ serverPort: " + serverPort,result);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object getClients(){
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("*****有服务：" + s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+ "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/feign/timeout")
    public String FeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/lb")
    public String lb(){
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String getZipkin(){
        return "zipkin追踪链路";
    }





}
