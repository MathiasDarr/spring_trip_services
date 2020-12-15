package org.mddarr.locationtracker.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("trips")
@Data
@NoArgsConstructor
public class CassandraTrip {

    @PrimaryKeyColumn(name="trip_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;
    private String user_id;
    private Double trip_length;

    public CassandraTrip(String trip_id, String user_id){
        this.id = trip_id;
        this.user_id = user_id;
        this.trip_length = 0.0;
    }

    public String getTrip_id() {
        return id;
    }

    public void setTrip_id(String trip_id) {
        this.id = trip_id;
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


