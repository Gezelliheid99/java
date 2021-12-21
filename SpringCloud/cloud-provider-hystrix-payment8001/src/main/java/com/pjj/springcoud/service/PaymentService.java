package com.pjj.springcoud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.Name;

/**
 * @author 潘俊杰
 * @date 2021年10月23日 21:43
 */
@Service
public class PaymentService {

    /**
     * 程序运行正常
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Ok,id:" + id + "\t" + "程序正常";
    }

    /**
     * 程序运行超时
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(){
        int timeout = 3;
        // int i = 10/0;
        try {
            Thread.sleep(timeout*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_Timeout" + "\t" + "程序正常,耗时：" + timeout +"秒";
    }

    /**
     * fallbackMethod
     * @return
     */
    public String paymentInfo_TimeoutHandler(){
        return "线程池：" + Thread.currentThread().getName() + "  系统繁忙或程序报错，请稍后再试！" +  "\t" + "o(╥﹏╥)o";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")  //失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw  new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功!，流水号：" + uuid;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数o(╥﹏╥)o,id:" + id;
    }
















}
