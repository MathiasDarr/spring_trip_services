package org.mddarr.tripservice.models;

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
    private Double distance;
    private Double length;

    public CassandraTrip(String user_id, String trip_id){
        this.id = trip_id;
        this.user_id = user_id;
        this.distance = 0.0;
        this.length = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}


