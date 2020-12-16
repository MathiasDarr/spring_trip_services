package org.mddarr.locationtracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@AllArgsConstructor
@Data
public class CoordinatesMessage {

    public enum MessageType {
        CHAT, LEAVE, JOIN, START, END
    }
    private String trip_id;
    private Double lat;
    private Double lng;
    private Date time;
    private MessageType type;

    public CoordinatesMessage() {
    }

    public CoordinatesMessage(String trip_id, Date time, Double lat, Double lng ) {
        this.trip_id = trip_id;
        this.lat = lat;
        this.lng = lng;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MessageType getType() {
        return type;
    }
    public void setType(MessageType type) {
        this.type = type;
    }


    public Double getLat() { return lat; }

    public void setLat(Double lat) { this.lat = lat; }

    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }

}
