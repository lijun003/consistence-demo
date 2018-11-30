package com.blocks.order.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message implements Serializable {
    private int id;
    private String serialNumber;
    private String body;
    private int status;
}
