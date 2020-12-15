package org.mddarr.locationtracker.services;

import org.mddarr.locationtracker.models.CassandraTrip;
import org.mddarr.locationtracker.models.TripDataPoint;
import org.mddarr.locationtracker.repository.TripDataRepository;
import org.mddarr.locationtracker.repository.TripRepository;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TripService {

    private final TripDataRepository tripDataRepository;
    private final TripRepository tripRepository;
    private final CassandraOperations cassandraTemplate;


    public TripService(TripDataRepository tripDataRepository, TripRepository tripRepository, CassandraOperations cassandraTemplate){
        this.tripDataRepository = tripDataRepository;
        this.cassandraTemplate = cassandraTemplate;
        this.tripRepository = tripRepository;
    }

    public List<CassandraTrip> getAllTrips(){
        return tripRepository.getTrips();
    }

    public List<TripDataPoint> getTripData(String user_id, String trip_id){
        return this.tripDataRepository.getTripData(user_id, trip_id);
    }

    public String createNewTrip(String user_id) {
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String trip_id = UUID.randomUUID().toString();
        CassandraTrip trip = new CassandraTrip(user_id, trip_id);
        cassandraTemplate.insert(trip);
        return trip_id;
    }

//    public Object getTrip(String id){
//        return cassandraTemplate.selectOneById(id,Trip);
//    }





}
