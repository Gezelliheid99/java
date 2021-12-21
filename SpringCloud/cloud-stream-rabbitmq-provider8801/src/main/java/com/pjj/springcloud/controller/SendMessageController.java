package com.pjj.springcloud.controller;

import com.pjj.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年10月29日 14:19
 */
@RestController
public class SendMessageController {
    @Resource
    private MessageProvider provider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return provider.sendMessage();
    }
}
