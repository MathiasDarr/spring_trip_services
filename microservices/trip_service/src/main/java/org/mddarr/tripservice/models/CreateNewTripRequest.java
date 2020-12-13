package org.mddarr.tripservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateNewTripRequest {
    String user_id;

    public CreateNewTripRequest(String user_id){
        this.user_id = user_id;

    }



}
