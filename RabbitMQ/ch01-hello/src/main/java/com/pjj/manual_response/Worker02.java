package com.pjj.manual_response;

import com.pjj.utils.GetChannel;
import com.pjj.utils.SleepUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月07日 14:19
 */
public class Worker02 {
    public static final String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        System.out.println("C1正在等待接收消息……处理时间较短");
        DeliverCallback deliverCallback = (ConsumerTag,message) -> {
            //睡眠一秒钟
            SleepUtils.sleep(1);
            System.out.println("接收到的消息：" + new String(message.getBody(),"UTF-8"));
            //手动应答
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费者消费回调逻辑");
        };
        //设置公平分发,默认为0，轮询分发，设置为1，让空闲的工人处理消息。
        channel.basicQos(2);
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck,deliverCallback,cancelCallback);


    }
}
