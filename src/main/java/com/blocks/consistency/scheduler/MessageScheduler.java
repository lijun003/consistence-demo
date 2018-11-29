package com.blocks.consistency.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.blocks.consistency.entity.Message;
import com.blocks.consistency.mapper.MessageMapper;
import com.blocks.consistency.service.MqService;

@Component
public class MessageScheduler {
    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MqService mqService;

    @Scheduled(fixedDelayString = "3600000")
    public void start() {
        List<Message> messages = messageMapper.findByStatus(0);
        messages.forEach(message -> mqService.send(message));
    }
}
