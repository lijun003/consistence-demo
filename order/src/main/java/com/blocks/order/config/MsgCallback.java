package com.blocks.order.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import com.blocks.order.mapper.MessageMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsgCallback implements ConfirmCallback, ReturnCallback {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("Ack: {}", b);
        if (b) {
            messageMapper.updateStatus(Integer.parseInt(correlationData.getId()), 1);
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
