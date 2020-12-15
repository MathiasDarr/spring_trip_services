package org.mddarr.locationtracker.controller;


import org.mddarr.locationtracker.dto.requests.CreateNewTripRequest;
import org.mddarr.locationtracker.dto.responses.Trip;
import org.mddarr.locationtracker.models.CassandraTrip;
import org.mddarr.locationtracker.models.CassandraTripDataPoint;
import org.mddarr.locationtracker.services.TripService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService= tripService;
    }

    @PostMapping(value="trips/start")
    public String postNewTrip(){
        String userid = "041b1dc9-b569-4a21-92cb-62d30f0b2c3f";
        return this.tripService.createNewTrip(userid);
    }

    @GetMapping(value="trips")
    public List<CassandraTrip> getAllTrips(){
        return tripService.getAllTrips();
    }

    @GetMapping(value="trips/{userid}/{tripid}")
    public List<CassandraTripDataPoint> getTripData(@PathVariable String userid, @PathVariable String tripid){
        return tripService.getTripData(userid, tripid);
    }


}


