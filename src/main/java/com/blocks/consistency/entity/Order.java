package com.blocks.consistency.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private Integer inventoryId;
    private Integer count;
    private int status;
}
