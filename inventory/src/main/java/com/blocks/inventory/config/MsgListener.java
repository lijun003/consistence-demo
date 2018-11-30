package com.blocks.inventory.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blocks.inventory.mapper.MessageMapper;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class MsgListener implements ChannelAwareMessageListener {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
//        log.info("Receive message: {}", message);
//        message.getBody();
//        String serialNumber = msg.getSerialNumber();
    }
}
