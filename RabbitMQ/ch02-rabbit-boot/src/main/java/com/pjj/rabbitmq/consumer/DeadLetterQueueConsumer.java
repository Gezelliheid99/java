package com.pjj.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 潘俊杰
 * @date 2021年10月10日 16:03
 * TTL的消费者
 */
@Slf4j
@Component
public class DeadLetterQueueConsumer {
    @RabbitListener(queues = "QD")
    public void receiveD(Message message, Channel channel) throws Exception{
        String msg = new String(message.getBody(),"UTF-8");
        log.info("当前时间：{},收到死信队列的消息:{}",new Date().toString(),msg);
    }
}
