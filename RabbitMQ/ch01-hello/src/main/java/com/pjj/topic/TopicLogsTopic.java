package com.pjj.topic;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 14:35
 */
public class TopicLogsTopic {
    public static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要发送的消息：");
        while (scanner.hasNext()){
            String message = scanner.next();
            System.out.print("请输入routingKey:");
            String routingKey = scanner.next();
            channel.basicPublish(EXCHANGE_NAME,routingKey, null, message.getBytes("UTF-8"));
            System.out.println("消息发送完成：" + message);
            System.out.print("请输入要发送的消息：");
        }
    }
}
