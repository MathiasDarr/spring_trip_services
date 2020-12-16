package org.mddarr.locationtracker.services;

import org.mddarr.locationtracker.models.CoordinatesMessage;

public interface LocationService {

    public void postCoordsData(CoordinatesMessage coordinatesMessage);
}
