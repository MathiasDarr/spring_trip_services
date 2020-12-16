package org.mddarr.tripservice.controllers;


import org.mddarr.tripservice.models.CassandraTrip;
import org.mddarr.tripservice.models.CassandraTripDataPoint;
import org.mddarr.tripservice.services.TripServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TripController {
    private final TripServiceImpl tripService;

    public TripController(TripServiceImpl tripService){
        this.tripService= tripService;
    }

    @PutMapping(value="trips/start")
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

    @DeleteMapping("/trips/{tripid}")
    ResponseEntity<String> deleteTrip(@PathVariable String tripid) {
        tripService.deleteTrip(tripid);
        return ResponseEntity.noContent().build();
    }

}


