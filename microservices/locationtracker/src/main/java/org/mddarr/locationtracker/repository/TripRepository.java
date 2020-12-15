package org.mddarr.locationtracker.repository;

import org.mddarr.locationtracker.models.CassandraTrip;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CassandraRepository<CassandraTrip, Long> {

    @Query("SELECT * from trips;")
    List<CassandraTrip> getTrips();

    @Query("DELETE FROM trips where trip_id=?0")
    void deleteTrip(String tripid);

}