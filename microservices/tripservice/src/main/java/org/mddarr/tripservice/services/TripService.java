package org.mddarr.tripservice.services;



import org.mddarr.tripservice.models.CassandraTrip;
import org.mddarr.tripservice.models.CassandraTripDataPoint;

import java.util.List;

public interface TripService {


    public List<CassandraTrip> getAllTrips();
    public List<CassandraTripDataPoint> getTripData(String user_id, String trip_id);
    public boolean deleteTrip(String trip_id);
    public String createNewTrip(String user_id);


}
