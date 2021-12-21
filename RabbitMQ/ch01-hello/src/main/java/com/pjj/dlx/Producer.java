package com.pjj.dlx;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 16:18
 * 死信队列的生产者
 */
public class Producer {
    /**
     * 普通交换机
     */
    public static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        System.out.println("消息正在发送中……");
        //设置ttl time to live
        // AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();
        for (int i = 1; i < 11; i++) {
            String message = i + "";
            channel.basicPublish(NORMAL_EXCHANGE, "normal", null, message.getBytes("UTF-8"));
        }




    }
}
