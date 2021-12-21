package com.pjj.publish;

import com.pjj.utils.GetChannel;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

/**
 * @author 潘俊杰
 * @date 2021年10月07日 16:32
 */
public class ConfirmMessage {
    /**
     * 批量发消息的个数
     */
    public static final int MESSAGE_COUNT = 1000;


    public static void main(String[] args) throws InterruptedException, TimeoutException, IOException {
        // ConfirmMessage.publishMessageSingle();
        // ConfirmMessage.publishMessageMultiply();
        ConfirmMessage.publishMessageAsync();
    }

    /**
     * 单个发布确认
     * @throws IOException
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public static void publishMessageSingle() throws IOException, TimeoutException, InterruptedException {
        Channel channel = GetChannel.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            boolean flag = channel.waitForConfirms();
            if (flag){
                // System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("发布" + MESSAGE_COUNT + "条消息耗时：" + time + "ms");
    }

    /**
     * 批量确认发送
     * @throws IOException
     * @throws TimeoutException
     * @throws InterruptedException
     */
    public static void publishMessageMultiply() throws IOException, TimeoutException, InterruptedException {
        Channel channel = GetChannel.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        long begin = System.currentTimeMillis();
        //批量确认消息的大小
        int batchSize = 50;
        for (int i = 1; i <= MESSAGE_COUNT; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            //当发送了100次
            if (i%batchSize == 0){
                boolean flag = channel.waitForConfirms();
                if (flag){
                    // System.out.println("消息发送成功");
                }
            }
        }
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("批量确认发布" + MESSAGE_COUNT + "条消息耗时" + time + "ms");
    }

    public static void publishMessageAsync() throws IOException, TimeoutException {
        Channel channel = GetChannel.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        //开启确认发布
        channel.confirmSelect();
        /**
         * 准备一个安全有序的哈希表适用于高并发的情况下，存放要发送的消息
         * 1.将需要和消息进行关联
         * 2.轻松批量删除条目，只要给到序号
         * 3.支持多线程
         */
        ConcurrentSkipListMap<Object,String> map = new ConcurrentSkipListMap<>();

        //准备一个监听器，监听哪些消息发送成功，哪些消息发送失败。
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                //2.删除掉已经确认的消息，剩下的就是未确认的消息,判断是否批量确认
                if (multiple){
                    ConcurrentNavigableMap<Object, String> confirmed = map.headMap(deliveryTag);
                    confirmed.clear();
                }else {
                    map.remove(deliveryTag);
                }
                System.out.println("确认的消息：" + deliveryTag);
            }
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                String messageNames = map.get(deliveryTag);
                System.err.println(messageNames + "未确认的消息：" + deliveryTag);
            }
        });
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message =  i + "";
            //1.记录下所有要发送的消息
            map.put(channel.getNextPublishSeqNo(), message);
            channel.basicPublish("", queueName, null, message.getBytes());
        }
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println("异步确认发布" + MESSAGE_COUNT + "条消息耗时" + time + "ms");
    }













}
