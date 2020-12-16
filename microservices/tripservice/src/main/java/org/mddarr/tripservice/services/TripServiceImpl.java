package org.mddarr.tripservice.services;


import org.mddarr.tripservice.models.CassandraTrip;
import org.mddarr.tripservice.models.CassandraTripDataPoint;
import org.mddarr.tripservice.repository.TripDataRepository;
import org.mddarr.tripservice.repository.TripRepository;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {

    private final TripDataRepository tripDataRepository;
    private final TripRepository tripRepository;
    private final CassandraOperations cassandraTemplate;


    public TripServiceImpl(TripDataRepository tripDataRepository, TripRepository tripRepository, CassandraOperations cassandraTemplate){
        this.tripDataRepository = tripDataRepository;
        this.cassandraTemplate = cassandraTemplate;
        this.tripRepository = tripRepository;
    }

    @Override
    public List<CassandraTrip> getAllTrips() {
        return tripRepository.getTrips();
    }

    @Override
    public List<CassandraTripDataPoint> getTripData(String user_id, String trip_id) {
        return this.tripDataRepository.getTripData(user_id, trip_id);
    }

    @Override
    public boolean deleteTrip(String trip_id) {
        return false;
    }

    @Override
    public String createNewTrip(String user_id) {
        String trip_id = UUID.randomUUID().toString();
        CassandraTrip trip = new CassandraTrip(user_id, trip_id);
        cassandraTemplate.insert(trip);
        return trip_id;
    }
//
//    public boolean deleteTrip(String trip_id){
//        tripRepository.deleteTrip(trip_id);
//        return true;
//    }
//



}
