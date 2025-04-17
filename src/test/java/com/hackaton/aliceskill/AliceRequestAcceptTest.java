package com.hackaton.aliceskill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.aliceskill.dto.Request;
import com.hackaton.aliceskill.dto.RequestAlice;
import com.hackaton.aliceskill.dto.ResponseServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class AliceRequestAcceptTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    String generateResponse(){
        return "{\n" +
                "  \"response\": {\n" +
                "    \"text\": \"Здравствуйте! Это мы, хороводоведы.\",\n" +
                "    \"tts\": \"Здравствуйте! Это мы, хоров+одо в+еды.\",\n" +
                "    \"card\": {\n" +
                "     \n" +
                "    },     \n" +
                "    \"buttons\": [\n" +
                "        {\n" +
                "            \"title\": \"Надпись на кнопке\",\n" +
                "            \"payload\": {},\n" +
                "            \"url\": \"https://example.com/\",\n" +
                "            \"hide\": true\n" +
                "        }\n" +
                "    ],\n" +
                "    \"end_session\": false,\n" +
                "    \"directives\": {}\n" +
                "  },\n" +
                "  \"session_state\": {\n" +
                "      \"value\": 10\n" +
                "  },\n" +
                "  \"user_state_update\": {\n" +
                "      \"value\": 42\n" +
                "  },\n" +
                "  \"application_state\": {\n" +
                "      \"value\": 37\n" +
                "  },\n" +
                "  \"analytics\": {\n" +
                "        \"events\": [\n" +
                "            {\n" +
                "                \"name\": \"custom event\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"another custom event\",\n" +
                "                \"value\": {\n" +
                "                    \"field\": \"some value\",\n" +
                "                    \"second field\": {\n" +
                "                        \"third field\": \"custom value\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "  \"version\": \"1.0\"\n" +
                "}\n";
    }

    String generateRequestButtonPressed() {
        String req = "\"request\": {\n" +
                "    \"nlu\": {\n" +
                "      \"tokens\": [\n" +
                "        \"надпись\",\n" +
                "        \"на\",\n" +
                "        \"кнопке\"\n" +
                "      ],\n" +
                "      \"entities\": [],\n" +
                "      \"intents\": {}\n" +
                "    },\n" +
                "    \"payload\": {},\n" +
                "    \"type\": \"ButtonPressed\"\n" +
                "  },";

        return req;
    }

    String generateRequestUtterance() {
        String req = "\"request\": {\n" +
                "    \"command\": \"закажи пиццу на улицу льва толстого 16 на завтра\",\n" +
                "    \"original_utterance\": \"закажи пиццу на улицу льва толстого, 16 на завтра\",\n" +
                "    \"markup\": {\n" +
                "      \"dangerous_context\": true\n" +
                "    },\n" +
                "    \"payload\": {},\n" +
                "    \"nlu\": {\n" +
                "      \"tokens\": [\n" +
                "        \"закажи\",\n" +
                "        \"пиццу\",\n" +
                "        \"на\",\n" +
                "        \"льва\",\n" +
                "        \"толстого\",\n" +
                "        \"16\",\n" +
                "        \"на\",\n" +
                "        \"завтра\"\n" +
                "      ],\n" +
                "      \"entities\": [\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 2,\n" +
                "            \"end\": 6\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.GEO\",\n" +
                "          \"value\": {\n" +
                "            \"house_number\": \"16\",\n" +
                "            \"street\": \"льва толстого\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 3,\n" +
                "            \"end\": 5\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.FIO\",\n" +
                "          \"value\": {\n" +
                "            \"first_name\": \"лев\",\n" +
                "            \"last_name\": \"толстой\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 5,\n" +
                "            \"end\": 6\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.NUMBER\",\n" +
                "          \"value\": 16\n" +
                "        },\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 6,\n" +
                "            \"end\": 8\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.DATETIME\",\n" +
                "          \"value\": {\n" +
                "            \"day\": 1,\n" +
                "            \"day_is_relative\": true\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"intents\": {}\n" +
                "    },\n" +
                "    \"type\": \"SimpleUtterance\"\n" +
                "  },";
        return req;
    }

    interface CreateReqType {
        String generate();
    }



    String generateRequestAlice(CreateReqType reqType) {
        String request = "{\n" +
                "  \"meta\": {\n" +
                "    \"locale\": \"ru-RU\",\n" +
                "    \"timezone\": \"Europe/Moscow\",\n" +
                "    \"client_id\": \"ru.yandex.searchplugin/7.16 (none none; android 4.4.2)\",\n" +
                "    \"interfaces\": {\n" +
                "      \"screen\": {},\n" +
                "      \"account_linking\": {},\n" +
                "      \"audio_player\": {}\n" +
                "    }\n" +
                "  },\n" + reqType.generate() +
                "  \n" +
                "  \"session\": {\n" +
                "    \"message_id\": 0,\n" +
                "    \"session_id\": \"2eac4854-fce721f3-b845abba-20d60\",\n" +
                "    \"skill_id\": \"3ad36498-f5rd-4079-a14b-788652932056\",\n" +
                "    \"user_id\": \"47C73714B580ED2469056E71081159529FFC676A4E5B059D629A819E857DC2F8\",\n" +
                "    \"user\": {\n" +
                "      \"user_id\": \"6C91DA5198D1758C6A9F63A7C5CDDF09359F683B13A18A151FBF4C8B092BB0C2\",\n" +
                "      \"access_token\": \"AgAAAAAB4vpbAAApoR1oaCd5yR6eiXSHqOGT8dT\"\n" +
                "    },\n" +
                "    \"application\": {\n" +
                "      \"application_id\": \"47C73714B580ED2469056E71081159529FFC676A4E5B059D629A819E857DC2F8\"\n" +
                "    },\n" +
                "    \"new\": true\n" +
                "  },\n" +
                "  \"state\": {\n" +
                "    \"session\": {\n" +
                "      \"value\": 10\n" +
                "    },\n" +
                "    \"user\": {\n" +
                "      \"value\": 42\n" +
                "    },\n" +
                "    \"application\": {\n" +
                "      \"value\": 37\n" +
                "    }\n" +
                "  },  \n" +
                "  \"version\": \"1.0\"\n" +
                "}\n";
        return request;
    }

    @Test
    void testHandlerRequestAlice() throws Exception {
        String request = generateRequestAlice(this::generateRequestUtterance);
        System.out.println(request);
        RequestAlice requestAlice = objectMapper.readValue(request, RequestAlice.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/alice").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status()
                .isOk()
        );
    }

    @Test
    void testHandlerResponse() throws Exception {
        String request = generateRequestAlice(this::generateRequestUtterance);
        log.info(request);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/alice").contentType(MediaType.APPLICATION_JSON).content(request)).andExpect(status()
                .isOk()
        ).andReturn();

        ResponseServer responseServer1=objectMapper.readValue(result.getResponse().getContentAsString(), ResponseServer.class);
        log.info(responseServer1.getResponse().getButtons().get(0).getTitle());
    }

}
