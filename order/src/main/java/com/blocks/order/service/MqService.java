package com.blocks.order.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blocks.common.dto.MessageTransfer;
import com.blocks.order.entity.Message;

@Service
public class MqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(MessageTransfer message) {

        this.rabbitTemplate.convertAndSend("inventory-queue1", message, new CorrelationData(String.valueOf(message.getId())));
    }
}
