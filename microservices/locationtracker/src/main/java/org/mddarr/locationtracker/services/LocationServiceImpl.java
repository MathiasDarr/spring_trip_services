package org.mddarr.locationtracker.services;

import org.mddarr.locationtracker.models.CassandraTripDataPoint;
import org.mddarr.locationtracker.models.CoordinatesMessage;
import org.mddarr.locationtracker.repository.TripDataRepository;
import org.springframework.stereotype.Service;


@Service
public class LocationServiceImpl implements LocationService{

    private final TripDataRepository tripDataRepository;

    public LocationServiceImpl(TripDataRepository tripDataRepository){
        this.tripDataRepository = tripDataRepository;
    }

    @Override
    public void postCoordsData(CoordinatesMessage coordinatesMessage){
        CassandraTripDataPoint cassandraTripDataPoint = new CassandraTripDataPoint(coordinatesMessage.getTrip_id(), coordinatesMessage.getTime(),coordinatesMessage.getLat(), coordinatesMessage.getLng());
        CassandraTripDataPoint item = tripDataRepository.insert(cassandraTripDataPoint);
    }
}
