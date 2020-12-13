package org.mddarr.tripservice.services;

import org.mddarr.tripservice.models.TripDataPoint;
import org.mddarr.tripservice.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final CassandraOperations cassandraTemplate;

    public TripService(TripRepository tripRepository, CassandraOperations cassandraTemplate){
        this.tripRepository = tripRepository;
        this.cassandraTemplate = cassandraTemplate;
    }

    public List<TripDataPoint> getTripData(String user_id, String trip_id){
        return this.tripRepository.getTripData(user_id, trip_id);
    }


}
