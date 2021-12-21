package com.pjj.dlx;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月08日 15:48
 */
public class Consumer01 {
    /**
     * 普通交换机
     */
    public static final String NORMAL_EXCHANGE = "normal_exchange";
    /**
     * 死信交换机
     */
    public static final String DEAD_EXCHANGE = "dead_exchange";
    /**
     * 普通队列
     */
    public static final String NORMAL_QUEUE = "normal_queue";
    /**
     * 死信队列
     */
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();

        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        //声明普通队列,初始值为 2/0.75 + 1 = 5
        Map<String, Object> arguments = new HashMap<>(5);
        //过期时间,一般在生产者处设置过期时间
        //正常队列设置为死信交换机
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //死信消息推送到哪个routingKey中去
        arguments.put("x-dead-letter-routing-key","dead");
        //设置队列最大长度
        // arguments.put("x-max-length", 6);
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, arguments);
        //声明死信队列
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);
        //队列与交换机绑定
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "normal");
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "dead");
        System.out.println("C1正在等待接收消息……");
        DeliverCallback deliverCallback = (consumerTap,message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            if ("5".equals(msg)){
                System.err.println("消息"+ msg + "被拒绝");
                channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
            }else {
                System.out.println("C1接收到的消息：" + msg);
                channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
            }
        };
        channel.basicConsume(NORMAL_QUEUE, false,deliverCallback,message -> {});
    }


}
