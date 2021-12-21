package com.pjj.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 潘俊杰
 * @date 2021年10月12日 16:19
 */
@Slf4j
@Component
public class MyCallback implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnsCallback{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 注入到RabbitTemplate中
     */
    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 发消息，交换机，回调
     *
     * @param correlationData 保存回调消息的id和相关信息
     * @param ack  交换机是否收到消息
     * @param cause 原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData!=null?correlationData.getId():"";
        if (ack){
            log.info("确认交换机已经接受到了id为：{}的消息",id);
        }else {
            log.info("确认交换机未收到id:{}发送来的消息，原因为：{}",id,cause);
        }
    }

    /**
     * 将不可达目的地的消息回退给生产者
     * @param returnedMessage
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("消息{},被交换机{}退回，退回原因:{},路由key:{}",
                new String(returnedMessage.getMessage().getBody()),returnedMessage.getReplyText(),
                returnedMessage.getExchange(),returnedMessage.getRoutingKey());
    }
}
