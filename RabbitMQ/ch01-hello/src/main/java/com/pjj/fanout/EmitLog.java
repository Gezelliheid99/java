package com.pjj.fanout;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 13:28
 * 交换机类型为fanout时，只有队列和生产者绑定的是一个交换机，绑定在次交换机上的所有队列，不论routingKey是否相等，都会接收到消息。
 */
public class EmitLog {
    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        //生产者只需要声明交换机，不需要绑定，因为只有一个生产者。
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要发送的消息：");
        while (scanner.hasNext()){
            String message = scanner.nextLine();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println("消息发送成功：" +message);
            System.out.println("请输入需要发送的消息：");
        }

    }
}
