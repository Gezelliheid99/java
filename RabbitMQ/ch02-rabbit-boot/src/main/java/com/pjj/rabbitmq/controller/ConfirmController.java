package com.pjj.rabbitmq.controller;

import com.pjj.rabbitmq.config.ConfirmQueueConfig;
import com.pjj.rabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 潘俊杰
 * @date 2021年10月12日 14:52
 */
@Slf4j
@RestController
@RequestMapping("/confirm")
public class ConfirmController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/confirmMsg/{message}/{id}")
    public void confirmMsg(@PathVariable String message,
                           @PathVariable String id){
        CorrelationData correlationData = new CorrelationData(id);
        rabbitTemplate.convertAndSend(ConfirmQueueConfig.CONFIRM_EXCHANGE_NAME,
                ConfirmQueueConfig.CONFIRM_ROUTINGKEY,message,correlationData);
        log.info("消息已经发送：{}",message);
    }
}
