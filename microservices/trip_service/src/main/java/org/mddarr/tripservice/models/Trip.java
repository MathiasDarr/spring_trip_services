package org.mddarr.tripservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;



import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.sql.Timestamp;


@Table("trips")
@Data
@NoArgsConstructor
public class Trip {

    @PrimaryKeyColumn(name="trip_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String trip_id;
    private String user_id;
    private Double trip_length;


    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Double getTrip_length() {
        return trip_length;
    }

    public void setTrip_length(Double trip_length) {
        this.trip_length = trip_length;
    }
}


