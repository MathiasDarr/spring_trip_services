package org.mddarr.locationtracker.models;

public class RideRequest {

    private Integer riders;

    private String location;
    private String destination;

    private Double location_lat;
    private Double location_lng;

    private Double destination_lat;
    private Double dstination_lng;

    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "[User= " + this.username + " is requesting a ride from " + this.location + " to destination " + this.destination + "]";
    }

}
