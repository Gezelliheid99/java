package com.pjj.topic;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 14:37
 */
public class ReceiveLogsTopic01 {
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        System.out.println("S1正在等待接收消息……");
        String queueName = "Q1";
        channel.queueDeclare(queueName,false,false,false, null);
        channel.queueBind(queueName, EXCHANGE_NAME, "*.orange.*");
        DeliverCallback deliverCallback = (consumerTag,message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody(),"UTF-8"));
        };
        channel.basicConsume(queueName, true, deliverCallback,message -> {});
    }
}
