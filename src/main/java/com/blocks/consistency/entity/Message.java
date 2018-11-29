package com.blocks.consistency.entity;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String serialNumber;
    private String body;
    private int status;
}
