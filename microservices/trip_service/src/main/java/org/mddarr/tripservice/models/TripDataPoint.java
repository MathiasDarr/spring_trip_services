package org.mddarr.tripservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("trip_data")
@Data
@NoArgsConstructor
public class TripDataPoint {

    @PrimaryKeyColumn(name="user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String user_id;

    @PrimaryKeyColumn(name="trip_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String trip_id;

    @PrimaryKeyColumn(name="time", ordinal = 2, type = PrimaryKeyType.CLUSTERED )
    private String time;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}


