package com.hackaton.aliceskill;

import com.hackaton.aliceskill.dto.Buttons;
import com.hackaton.aliceskill.dto.Request;
import com.hackaton.aliceskill.dto.Response;
import com.hackaton.aliceskill.dto.ResponseServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@org.springframework.stereotype.Service
@Slf4j
public class Service {


    public ResponseServer talkYandexAlice(Request request) {
        ResponseServer responseServer = new ResponseServer();
        Response response = new Response();
        Buttons buttons = new Buttons();
        buttons.setHide(true);
        buttons.setTitle("Начать");
        response.setButtons(List.of(buttons));
        response.setText("Привет, эт игра)");
        responseServer.setResponse(response);
        return responseServer;
    }

}
