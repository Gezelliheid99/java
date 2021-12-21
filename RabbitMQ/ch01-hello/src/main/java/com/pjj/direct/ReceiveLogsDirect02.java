package com.pjj.direct;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 13:58
 */
public class ReceiveLogsDirect02 {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        System.out.println("S2等待接收消息……");
        String queueName = "disk";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName,EXCHANGE_NAME,"error");
        DeliverCallback deliverCallback = (consumerTag,message) -> {
            System.out.println("接收到的消息:" + new String(message.getBody(),"UTF-8"));
        };
        channel.basicConsume(queueName, true, deliverCallback,message -> {});


    }
}
