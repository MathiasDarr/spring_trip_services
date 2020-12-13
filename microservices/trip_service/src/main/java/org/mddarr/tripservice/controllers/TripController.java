package org.mddarr.tripservice.controllers;

import org.mddarr.tripservice.models.CreateNewTripRequest;
import org.mddarr.tripservice.models.TripDataPoint;
import org.mddarr.tripservice.repository.TripRepository;
import org.mddarr.tripservice.services.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService){
        this.tripService = tripService;
    }

    @GetMapping(value="trips/{userid}/{tripid}")
    public List<TripDataPoint> getTripData(@PathVariable String userid, @PathVariable String tripid){
        return tripService.getTripData(userid, tripid);
    }

//    @PutMapping(value="trips/create/start")
//    public String startNewTrip(@RequestBody CreateNewTripRequest createNewTripRequest){
//
//    }
//
//    @PutMapping(value="trips/")
//    public void postTripData(){
//
//    }


}
