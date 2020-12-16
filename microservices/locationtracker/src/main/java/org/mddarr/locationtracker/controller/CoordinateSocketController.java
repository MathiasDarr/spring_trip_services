package org.mddarr.locationtracker.controller;

import org.mddarr.locationtracker.models.CoordinatesMessage;
import org.mddarr.locationtracker.models.CoordinatesResponse;
import org.mddarr.locationtracker.services.TripServiceImpl;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class CoordinateSocketController {

    private final TripServiceImpl tripService;

    public CoordinateSocketController(TripServiceImpl tripService){
        this.tripService = tripService;
    }

    @MessageMapping("/coordinates")
    @SendTo("/topic/coordinates")
    public CoordinatesResponse greeting(@Payload CoordinatesMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new CoordinatesResponse("Hello, " + message.getLat());
    }

}
