package com.trantor.bcryptencoder.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Encoder {
    private String source;
    private String target;
    private Integer rounds;
}
