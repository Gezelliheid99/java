package com.pjj.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.pjj.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author 潘俊杰
 * @date 2021年10月29日 14:12
 */
@EnableBinding(Source.class)
public class MessageChannelImpl implements MessageProvider {
    @Resource(name = "output")
    private MessageChannel channel;

    @Override
    public String sendMessage() {
        String UUID = IdUtil.simpleUUID();
        channel.send(MessageBuilder.withPayload(UUID).build());
        System.out.println("*********UUID: " + UUID);
        return UUID;
    }
}
