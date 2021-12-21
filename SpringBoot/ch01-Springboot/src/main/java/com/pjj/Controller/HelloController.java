package com.pjj.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘俊杰
 * @date 2021年09月15日 15:48
 */
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello,Springboot";
    }
}
