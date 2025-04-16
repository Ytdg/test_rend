package com.hackaton.aliceskill.dto;

import lombok.Data;

@Data
public class ResponseServer {
    private Response response;
    private final String version = "1.0";
}
