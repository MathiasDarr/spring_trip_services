package org.mddarr.tripservice.controllers;

import org.mddarr.tripservice.dto.requests.CreateNewTripRequest;
import org.mddarr.tripservice.dto.requests.PostTripDataRequest;
import org.mddarr.tripservice.models.Trip;
import org.mddarr.tripservice.models.TripDataPoint;
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

    @PutMapping(value="trips/create/start")
    public String startNewTrip(@RequestBody CreateNewTripRequest createNewTripRequest){
        return tripService.createNewTrip("041b1dc9-b569-4a21-92cb-62d30f0b2c3f",createNewTripRequest);
    }
//

    @GetMapping(value="trips")
    public List<Trip> getAllTrips(){
        return tripService.getAllTrips();
    }

    @PutMapping(value="trips/")
    public void postTripData(@RequestBody PostTripDataRequest postTripDataRequest){

    }


}
