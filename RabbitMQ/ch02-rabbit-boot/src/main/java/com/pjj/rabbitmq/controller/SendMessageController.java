package com.pjj.rabbitmq.controller;

import com.pjj.rabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 潘俊杰
 * @date 2021年10月10日 15:51
 */
@Slf4j
@RestController
@RequestMapping("/ttl")
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message){
        log.info("当前时间：{}，发送一条消息给两个TTL队列：{}",new Date().toString(),message);
        rabbitTemplate.convertAndSend("X", "XA","消息来自ttl为10s的队列：" + message);
        rabbitTemplate.convertAndSend("X", "XB","消息来自ttl为40s的队列：" + message);
    }

    @GetMapping("sendExpirationMsg/{message}/{ttl}")
    public void sendExpirationMsg(@PathVariable String message,
                                  @PathVariable String ttl){
        log.info("当前时间：{}，发送一条延迟为{}毫秒的消息给TTL队列QC：{}",
                new Date().toString(),ttl,message);
        rabbitTemplate.convertAndSend("X", "XC",message,msg -> {
            msg.getMessageProperties().setExpiration(ttl);
            return msg;
        });
    }

    @GetMapping("sendDelayedMsg/{message}/{delay}")
    public void sendDelayedMsg(@PathVariable String message,
                                  @PathVariable Integer delay){
        log.info("当前时间：{}，发送一条延迟为{}毫秒的消息给延迟队列QC：{}",
                  new Date().toString(),delay,message);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE, DelayedQueueConfig.DELAYED_ROUTING_KEY,
                                message,msg -> {
            msg.getMessageProperties().setDelay(delay);
            return msg;
                });

    }











}
