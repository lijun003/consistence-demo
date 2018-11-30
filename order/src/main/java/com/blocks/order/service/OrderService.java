package com.blocks.order.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blocks.common.util.JsonUtil;
import com.blocks.order.entity.Message;
import com.blocks.order.entity.Order;
import com.blocks.order.mapper.MessageMapper;
import com.blocks.order.mapper.OrderMapper;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Transactional
    public void placeOrder(int inventoryId, int count) {
        Order order = buildOrder(inventoryId, count);
        saveOrder(order);
        saveMessage(order);
    }

    private void saveMessage(Order order) {
        Message message = new Message();
        message.setSerialNumber(UUID.randomUUID().toString());
        message.setBody(JsonUtil.toJson(order));
        message.setStatus(0);
        messageMapper.insert(message);
    }

    private void saveOrder(Order order) {
        orderMapper.insert(order);
    }

    private Order buildOrder(int inventoryId, int count) {
        Order order = new Order();
        order.setInventoryId(inventoryId);
        order.setCount(count);
        return order;
    }
}
