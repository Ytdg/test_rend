package com.hackaton.aliceskill.dto;

import lombok.Data;

import java.util.List;

@Data
public class Response {
    private String text;
    private Card card;
    private List<Buttons> buttons;
    private boolean end_session;
}
