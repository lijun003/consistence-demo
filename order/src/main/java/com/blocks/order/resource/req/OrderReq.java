package com.blocks.order.resource.req;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderReq {
    @NotNull
    private Integer inventoryId;
    @NotNull
    private Integer count;
}
