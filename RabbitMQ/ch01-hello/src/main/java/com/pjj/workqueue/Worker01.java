package com.pjj.workqueue;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月07日 13:15
 */
public class Worker01 {

    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();



        DeliverCallback deliverCallback = (ConsumerTag,message) -> {
            System.out.println(ConsumerTag + "接收到的消息：" + new String(message.getBody()));
        };
        CancelCallback cancelCallback = ConsumerTag -> {
            System.out.println( ConsumerTag + "消费者取消消费接口回调逻辑");
        };
        System.out.println("T3等待接收消息");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback,cancelCallback);

    }
}
