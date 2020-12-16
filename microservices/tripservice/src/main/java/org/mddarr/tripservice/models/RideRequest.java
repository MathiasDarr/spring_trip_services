package org.mddarr.tripservice.models;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.sql.Timestamp;


public class RideRequest {

    @PrimaryKeyColumn(name="user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String user_id;

    @PrimaryKeyColumn(name="request_time", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Timestamp request_time;

    private Integer riders;

    private String location;
    private String destination;

    private Double location_lat;
    private Double location_lng;

    private Double destination_lat;
    private Double dstination_lng;

    public Integer getRiders() {
        return riders;
    }

    public void setRiders(Integer riders) {
        this.riders = riders;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        return dstination_lng;
    }

    public void setDstination_lng(Double dstination_lng) {
        this.dstination_lng = dstination_lng;
    }

    @Override
    public String toString() {
        return "[User= " + this.user_id + " is requesting a ride from " + this.location + " to destination " + this.destination + "]";
    }

}
