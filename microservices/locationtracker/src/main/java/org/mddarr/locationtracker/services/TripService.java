package org.mddarr.locationtracker.services;

import org.mddarr.locationtracker.models.CassandraTrip;
import org.mddarr.locationtracker.models.CassandraTripDataPoint;
import org.mddarr.locationtracker.models.CoordinatesMessage;

import java.util.List;
import java.util.UUID;

public interface TripService {


    public List<CassandraTrip> getAllTrips();
    public List<CassandraTripDataPoint> getTripData(String user_id, String trip_id);
    public boolean deleteTrip(String trip_id);
    public String createNewTrip(String user_id);


}
