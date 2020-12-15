package org.mddarr.location_tracker.controller;

import org.mddarr.location_tracker.model.CoordinatesMessage;
import org.mddarr.location_tracker.model.Greeting;
import org.mddarr.location_tracker.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
public class CoordinatesController {

    @MessageMapping("/coordinates")
    @SendTo("/topic/coordinates")
    public CoordinatesMessage coords(@Payload CoordinatesMessage coordinatesMessage) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new CoordinatesMessage(coordinatesMessage.getLat(), coordinatesMessage.getLng());
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(@Payload HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}

