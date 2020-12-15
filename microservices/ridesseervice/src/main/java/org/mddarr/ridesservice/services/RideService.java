package org.mddarr.ridesservice.services;

import org.mddarr.ridesservice.models.RideRequest;
import org.mddarr.ridesservice.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public List<RideRequest> getAllRides(){

        return rideRepository.getAllRides();

//        List<RideRequest> a = new ArrayList<>();
//        return a;
    }



}
