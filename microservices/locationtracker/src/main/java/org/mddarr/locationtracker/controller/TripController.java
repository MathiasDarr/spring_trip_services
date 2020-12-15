package org.mddarr.locationtracker.controller;


import org.mddarr.locationtracker.dto.responses.Trip;
import org.mddarr.locationtracker.services.TripService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService= tripService;
    }

    @PostMapping(value="trips/start")
    public String postNewTrip(){
        String userid = "dakobedbard@gmail.com";
        return this.tripService.createNewTrip(userid);
    }

//
//    @GetMapping(value="trips/{trip_id}")
//    public Trip getTrip(){
//        String userid = "dakobedbard@gmail.com";
//        tripService.
//
//    }


}


