package com.pjj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘俊杰
 * @date 2021年11月08日 21:51
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String TestA(){
        log.info("........testA");
        return "-----TestA";
    }
    @GetMapping("/testB")
    public String TestB(){
        return "-----TestB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // int i = 10 /0;
        log.info("#######testD");
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "Deal_testHotKey")
    public String TestHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "--------TestHotKey";
    }

    public String Deal_testHotKey(String p1, String p2, BlockException exception){
        return "--------TestHotKey o(╥﹏╥)o";
    }
}
