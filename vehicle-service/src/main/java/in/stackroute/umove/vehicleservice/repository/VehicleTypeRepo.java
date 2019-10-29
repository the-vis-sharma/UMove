package in.stackroute.umove.vehicleservice.repository;

import in.stackroute.umove.vehicleservice.model.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleTypeRepo extends MongoRepository<VehicleType,String> {


    VehicleType findByid(String id);
    VehicleType findByNameIgnoreCase(String name);
    Page<VehicleType> findAll(Pageable pageable);

    @Query("{'fuel.id':?0}")
    List<VehicleType> findByFuel(String fuel);
}