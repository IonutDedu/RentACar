package RentACar.RentACar.repository;

import RentACar.RentACar.entity.Truck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends VehicleRepository{

    @Query(value = "SELECT * FROM vehicle , truck where vehicle.id  = truck.id", nativeQuery = true)
    List<Truck> getAllTrucks();
}
