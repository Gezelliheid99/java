package com.pjj.direct;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 14:06
 */
public class DirectLogs {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        //生产者只需要声明交换机，不需要绑定，因为只有一个生产者。
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要发送的消息：");
        while (scanner.hasNext()){
            String message = scanner.next();
            channel.basicPublish(EXCHANGE_NAME,"info", null, message.getBytes("UTF-8"));
            System.out.println("消息发送完成：" + message);
            System.out.println("请输入需要发送的消息：");
        }
    }
}
