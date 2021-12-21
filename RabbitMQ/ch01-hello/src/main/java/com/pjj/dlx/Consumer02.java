package com.pjj.dlx;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 16:34
 */
public class Consumer02 {

    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        System.out.println("C2等待接收消息……");
        DeliverCallback deliverCallback = (consumerTag,message) -> {
            System.out.println("C2接受到的消息："+ new String(message.getBody(),"UTF-8"));
        };
        channel.basicConsume(DEAD_QUEUE, true,deliverCallback, message -> {});
    }
}
