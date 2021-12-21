package com.pjj.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 潘俊杰
 * @date 2021年10月12日 14:39
 */
@Configuration
public class ConfirmQueueConfig {
    /**
     * 交换机
     */
    public static final String CONFIRM_EXCHANGE_NAME="confirm_exchange";
    /**
     * 队列
     */
    public static final String CONFIRM_QUEUE="confirm_queue";
    /**
     * routingKey
     */
    public static final String CONFIRM_ROUTINGKEY = "key1";
    /**
     * 备份交换机
     */
    public static final String BACKUP_EXCHANGE = "backup_exchange";

    /**
     * 备份交换机
     */
    public static final String BACKUP_QUEUE="backup_queue";
    public static final String WARNING_QUEUE="warning_queue";


    @Bean("confirmExchange")
    public DirectExchange confirmExchange(){

        return ExchangeBuilder.directExchange(CONFIRM_EXCHANGE_NAME).withArgument("alternate-exchange",BACKUP_EXCHANGE).build();
    }

    @Bean("backupExchange")
    public FanoutExchange backupExchange(){
        return new FanoutExchange(BACKUP_EXCHANGE);
    }

    @Bean("backupQueue")
    public Queue backupQueue(){
        return QueueBuilder.durable(BACKUP_QUEUE).build();
    }

    @Bean("warningQueue")
    public Queue warningQueue(){
        return QueueBuilder.durable(WARNING_QUEUE).build();
    }

    @Bean("confirmQueue")
    public Queue confirmQueue(){
        return QueueBuilder.durable(CONFIRM_QUEUE).build();
    }

    @Bean
    public Binding exchangeBindingQueue(@Qualifier("confirmExchange") DirectExchange confirmExchange,
                                        @Qualifier("confirmQueue") Queue confirmQueue){
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with(CONFIRM_ROUTINGKEY);
    }

    @Bean
    public Binding backupBindingQueue(@Qualifier("backupExchange") FanoutExchange exchange,
                                      @Qualifier("backupQueue") Queue backupQueue){
        return BindingBuilder.bind(backupQueue).to(exchange);
    }

    @Bean
    public Binding backupBindingWarningQueue(@Qualifier("backupExchange") FanoutExchange exchange,
                                      @Qualifier("warningQueue") Queue warningQueue){
        return BindingBuilder.bind(warningQueue).to(exchange);
    }



}
