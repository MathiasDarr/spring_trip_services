package org.mddarr.ridesservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("ride_requests")
@Data
@NoArgsConstructor
public class Ride {
}
