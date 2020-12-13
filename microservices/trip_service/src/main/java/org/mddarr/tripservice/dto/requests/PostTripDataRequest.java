package org.mddarr.tripservice.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostTripDataRequest {
    String user_id;
    String trip_id;
    Double lat;
    Double lng;

}
