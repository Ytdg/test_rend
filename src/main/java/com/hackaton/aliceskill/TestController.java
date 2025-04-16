package com.hackaton.aliceskill;

import com.hackaton.aliceskill.dto.RequestAlice;
import com.hackaton.aliceskill.dto.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alice")
public class TestController {
    private final Service service;

    @Autowired
    TestController(Service service) {
        this.service = service;
    }

    @PostMapping
    ResponseServer handlerRequestAlice(@RequestBody RequestAlice requestAlice) {
        return service.talkYandexAlice(requestAlice.getRequest());
    }


}
