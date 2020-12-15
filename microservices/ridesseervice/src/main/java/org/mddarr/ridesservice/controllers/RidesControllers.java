package org.mddarr.ridesservice.controllers;

import org.mddarr.ridesservice.models.RideRequest;
import org.mddarr.ridesservice.services.RideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RidesControllers {

    private final RideService rideService;

    public RidesControllers(RideService rideService){
        this.rideService = rideService;
    }

    @GetMapping(value="rides/requests")
    public List<RideRequest> getAllRides(){
        return rideService.getAllRides();
    }

}
