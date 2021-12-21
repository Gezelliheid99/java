package com.pjj.rabbitmq.consumer;

import com.pjj.rabbitmq.config.ConfirmQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author 潘俊杰
 * @date 2021年10月12日 14:57
 */
@Slf4j
@Component
public class ConfirmConsumer {
    @RabbitListener(queues = ConfirmQueueConfig.CONFIRM_QUEUE)
    public void ConfirmConsumer(Message message) throws UnsupportedEncodingException {
        String msg = new String(message.getBody(),"UTF-8");
        log.info("队列接受到的消息：{}",msg);
    }
}
