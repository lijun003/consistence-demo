package com.blocks.consistency.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import com.blocks.consistency.entity.Message;
import com.blocks.consistency.mapper.MessageMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsgConfirmCallback implements ConfirmCallback {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("Ack: {}", b);
        if (b) {
            messageMapper.updateStatus(Integer.parseInt(correlationData.getId()), 1);
        }
    }
}
