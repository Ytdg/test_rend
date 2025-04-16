package com.hackaton.aliceskill.dto;

import lombok.Data;

@Data
public class Response {
    private String text;
    private Card card;
    private Buttons buttons;
}
