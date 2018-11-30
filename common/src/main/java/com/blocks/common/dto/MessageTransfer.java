package com.blocks.common.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageTransfer implements Serializable {
    private int id;
    private String serialNumber;
    private String body;
    private int status;
}
