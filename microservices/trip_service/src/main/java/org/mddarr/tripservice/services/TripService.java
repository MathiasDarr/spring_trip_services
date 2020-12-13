package org.mddarr.tripservice.services;

import org.mddarr.tripservice.dto.requests.CreateNewTripRequest;
import org.mddarr.tripservice.models.Trip;
import org.mddarr.tripservice.models.TripDataPoint;
import org.mddarr.tripservice.repository.TripDataRepository;
import org.mddarr.tripservice.repository.TripRepository;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripService {

    private final TripDataRepository tripDataRepository;
    private final CassandraOperations cassandraTemplate;
    private final TripRepository tripRepository;

    public TripService(TripDataRepository tripDataRepository, TripRepository tripRepository, CassandraOperations cassandraTemplate){
        this.tripDataRepository = tripDataRepository;
        this.cassandraTemplate = cassandraTemplate;
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips(){
        return tripRepository.getTrips();
    }

    public List<TripDataPoint> getTripData(String user_id, String trip_id){
        return this.tripDataRepository.getTripData(user_id, trip_id);
    }

    public String createNewTrip(String user_id, CreateNewTripRequest createNewTripRequest) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String trip_id = UUID.randomUUID().toString();
        return trip_id;
    }


}
