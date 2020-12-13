package org.mddarr.tripservice.repository;

import org.mddarr.tripservice.models.TripDataPoint;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CassandraRepository<TripDataPoint, Long> {

    @Query("SELECT * from trip_data where user_id=?0 and trip_id=?1")
    List<TripDataPoint> getTripData(String user_id, String trip_id);

}