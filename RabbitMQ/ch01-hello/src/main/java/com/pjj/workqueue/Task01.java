package com.pjj.workqueue;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月07日 13:33
 */
public class Task01 {
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        Map<String,Object> arguments = new HashMap<>();
        arguments.put("x-max-priority",10);
        channel.queueDeclare(QUEUE_NAME, false, false, false, arguments);
        for (int i = 0; i < 10; i++) {
            String message = i + "";
            if (i == 5){
                AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().priority(5).build();
                channel.basicPublish("", QUEUE_NAME, properties, message.getBytes());
            }else {
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            }
        }
        System.out.print("消息发送完成！");




    }
}
