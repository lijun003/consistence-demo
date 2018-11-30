package com.blocks.order.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blocks.order.resource.req.OrderReq;
import com.blocks.order.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderResource {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void placeOrder(@RequestBody OrderReq orderReq) {
        orderService.placeOrder(orderReq.getInventoryId(), orderReq.getCount());
    }
}
