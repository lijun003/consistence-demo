package com.blocks.order.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.blocks.common.dto.MessageTransfer;
import com.blocks.order.entity.Message;
import com.blocks.order.mapper.MessageMapper;
import com.blocks.order.service.MqService;
import com.github.dozermapper.core.Mapper;

@Component
public class MessageScheduler {
    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MqService mqService;

    @Autowired
    private Mapper mapper;

    @Scheduled(fixedDelayString = "20000", initialDelayString = "10000")
    public void start() {
        List<Message> messages = messageMapper.findByStatus(0);
        messages.forEach(message -> {
            MessageTransfer msgTransfer = mapper.map(message, MessageTransfer.class);
            mqService.send(msgTransfer);
        });
    }
}
