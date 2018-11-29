package com.blocks.consistency.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blocks.consistency.entity.Message;

@Service
public class MqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Message message) {
        this.rabbitTemplate.convertAndSend("inventory-queue", message, new CorrelationData(String.valueOf(message.getId())));
    }
}
