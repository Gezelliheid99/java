package com.pjj.hello;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月06日 19:06
 */
public class Consumer {
    public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        //接收消息
        DeliverCallback deliverCallback = (consumerTag,message) -> {
            System.out.println(new String(message.getBody()));
        };
        //消费者取消消息的回调
        CancelCallback cancelCallback = ConsumerTag -> {
            System.out.println("消费者消费被中断");
        };

        /**
         * 1.哪个消息队列
         * 2.是否自动发送ack确认帧
         * 3.消费者未成功是否自动回调
         * 4.消费者取消消息时消费者的回调
         */
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);


    }
}
