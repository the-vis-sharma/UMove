/**
 *  Service Interface for Zones
 */

// Package
package in.stackroute.umove.zoneservice.service;

// Importing files
import in.stackroute.umove.zoneservice.model.Zone;
import in.stackroute.umove.zoneservice.model.ZoneStatus;

import java.util.List;

public interface ServiceZone {
    Zone addNewZone(Zone zone);
    List<Zone> findAllZones();
    List<Zone> findByZoneName(String name);
    List<Zone> findZonesByLocality(String locality);
    Zone updateZoneDetails(String name, Zone zone);
    List<Zone> getNearbyZones(Double lon, Double lat);
    Zone findZoneBySupervisorId(String supervisorId);
    List<Zone> findByStatus(ZoneStatus status);
}
