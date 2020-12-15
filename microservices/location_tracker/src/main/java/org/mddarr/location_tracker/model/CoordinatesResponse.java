package org.mddarr.location_tracker.model;

public class CoordinatesResponse {
    private Double lat;
    private Double lng;
    private String content;

    public CoordinatesResponse(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
        this.content = "Lat: " + lat + " Lng: " + lng;
    }

    public CoordinatesResponse() { }

}
