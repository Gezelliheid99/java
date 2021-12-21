package com.pjj.rabbitmq.consumer;

import com.pjj.rabbitmq.config.ConfirmQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 潘俊杰
 * @date 2021年10月12日 19:06
 */
@Slf4j
@Component
public class WarningConsumer {
    @RabbitListener(queues = ConfirmQueueConfig.WARNING_QUEUE)
    public void warningConsume(Message message){
        String msg = new String(message.getBody());
        log.error("发现不可以路由的消息："+ msg);
    }

}
