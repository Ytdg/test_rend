package com.hackaton.aliceskill.dto;

import lombok.Data;

@Data
public class Request {
    private String command;
    private Nlu nlu;
    private String type;
}
