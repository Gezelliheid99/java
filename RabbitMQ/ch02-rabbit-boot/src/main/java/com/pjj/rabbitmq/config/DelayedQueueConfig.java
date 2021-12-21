package com.pjj.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘俊杰
 * @date 2021年10月11日 17:03
 */
@Configuration
public class DelayedQueueConfig {
    /**
     * 交换机
     */
    public static final String DELAYED_EXCHANGE = "delayed.exchange";
    /**
     * 队列
     */
    public static final String DELAYED_QUEUE = "delayed.queue";
    /**
     * routingKey
     */
    public static final String DELAYED_ROUTING_KEY = "delayed.routingKey";

    /**
     * 声明队列
     */
    @Bean
    public Queue delayedQueue(){
        return new Queue(DELAYED_QUEUE);
    }

    /**
     * 声明交换机
     */
    @Bean
    public CustomExchange delayedExchange(){
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE, "x-delayed-message", false, false, arguments);
    }

    /**
     * 绑定交换机
     */
    @Bean
    public Binding delayedQueueBindingDelayedExchange(@Qualifier("delayedQueue") Queue delayedQueue,
                                                      @Qualifier("delayedExchange")Exchange delayedExchange){
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();

    }














}
