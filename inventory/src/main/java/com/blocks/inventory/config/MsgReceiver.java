package com.blocks.inventory.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.blocks.common.dto.MessageTransfer;
import com.blocks.inventory.mapper.MessageMapper;

@Component
@RabbitListener(queues = "inventory-queue")
public class MsgReceiver {
    @Autowired
    private MessageMapper messageMapper;

    @RabbitHandler
    public void process(@Payload MessageTransfer msgTransfer) {
        System.out.println("Receiver : "  + msgTransfer);
    }

}