package com.pjj.fanout;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 13:28
 */
public class ReceiveLogs2 {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //生命一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,EXCHANGE_NAME,"");
        System.out.println("S2正在等待接收消息……");
        DeliverCallback deliverCallback = (consumer,message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody(),"UTF-8"));
        };
        channel.basicConsume(queueName, true,deliverCallback,consumerTag -> {});

    }
}
