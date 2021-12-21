package com.pjj.hello;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月06日 17:22
 */
public class Producer {
    public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        /**
         * 1.队列名称
         * 2.服务器重启后队列是否还存在
         * 3.是否进行消息贡共享 true则为不共享 反之共享
         * 4.最后一个消费者断开连接后，是否自动删除队列
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "hello.world";
        /**
         * 1.交换机名称
         * 2.路由的key值，本次是队列的名称
         * 3.其他参数信息
         * 4.发送的消息， 需要二进制化
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息发送完毕");
    }
}
