package org.mddarr.locationtracker.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;


@Table("trip_data")
@Data
@NoArgsConstructor
public class CassandraTripDataPoint {


    @PrimaryKeyColumn(name="trip_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String trip_id;

    @PrimaryKeyColumn(name="time", ordinal = 1, type = PrimaryKeyType.CLUSTERED )
    private Timestamp time;

    private Double lat;
    private Double lng;

    public String getTrip_id() {
        return trip_id;
    }
    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }




}


