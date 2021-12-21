package com.pjj.rabbitmq.consumer;

import com.pjj.rabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author 潘俊杰
 * @date 2021年10月11日 17:40
 */
@Slf4j
@Component
public class DelayedQueueConsumer {
    /**
     * 监听消息
     */
    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE)
    public void receiveDelayedMessage(Message message) throws UnsupportedEncodingException {
        String msg = new String(message.getBody(),"UTF-8");
        log.info("当前时间：{},收到的消息是：{}",new Date().toString(),msg);

    }
}
