package org.mddarr.ridesservice.repository;

import org.mddarr.ridesservice.models.RideRequest;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends CassandraRepository<RideRequest, Long> {

    @Query("SELECT * FROM ride_requests")
    public List<RideRequest> getAllRides();


}
