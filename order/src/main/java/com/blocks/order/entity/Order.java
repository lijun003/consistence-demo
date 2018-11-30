package com.blocks.order.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer inventoryId;
    private Integer count;
    private int status;
}
