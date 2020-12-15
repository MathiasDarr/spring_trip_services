package org.mddarr.ridesservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Table("ride_requests")
@Data
@NoArgsConstructor
public class RideRequest {

    @PrimaryKeyColumn(name="user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String user_id;

    @PrimaryKeyColumn(name="request_time", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Date request_time;

    private Integer riders;

    private String destination;

    private Double location_lat;
    private Double location_lng;

    private Double destination_lat;
    private Double destination_lng;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getRequest_time() {
        return request_time;
    }

    public void setRequest_time(Date request_time) {
        this.request_time = request_time;
    }

    public Integer getRiders() {
        return riders;
    }

    public void setRiders(Integer riders) {
        this.riders = riders;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(Double location_lat) {
        this.location_lat = location_lat;
    }

    public Double getLocation_lng() {
        return location_lng;
    }

    public void setLocation_lng(Double location_lng) {
        this.location_lng = location_lng;
    }

    public Double getDestination_lat() {
        return destination_lat;
    }

    public void setDestination_lat(Double destination_lat) {
        this.destination_lat = destination_lat;
    }

    public Double getDstination_lng() {
        return destination_lng;
    }

    public void setDstination_lng(Double dstination_lng) {
        this.destination_lng = dstination_lng;
    }

    @Override
    public String toString() {
        return "[User= " + this.user_id + " is requesting a ride]";
    }

}
