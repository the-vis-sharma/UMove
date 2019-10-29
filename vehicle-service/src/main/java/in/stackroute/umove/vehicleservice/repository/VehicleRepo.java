package in.stackroute.umove.vehicleservice.repository;


import in.stackroute.umove.vehicleservice.model.Vehicle;
import in.stackroute.umove.vehicleservice.model.VehicleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VehicleRepo extends MongoRepository<Vehicle,String> {

    /*@Query(value = "{ 'type' : { 'name': {$regex : ?0, $options: 'i'}}}")
    List<Vehicle> findByTypeName(String name);*/
    @Query("{'vehicleType.name':?0}")
   Page<Vehicle> findByType(String vehicleType, Pageable pageable);
   @Query("{ 'zoneId':?0, 'vehicleType.name':?1}")
   Page<Vehicle> findByZoneType(String zone, String type, Pageable pageable);

    Page<Vehicle> findByzoneId(String zone_id, Pageable pageable);
    Vehicle findByregistrationNoIgnoreCase(String name);
    Vehicle findByChassisNumberIgnoreCase(String name);
    Vehicle findByInsuranceNoIgnoreCase(String name);
    Page<Vehicle> findByStatus(VehicleStatus status, Pageable pageable);
    Page<Vehicle> findAll(Pageable pageable);


}
