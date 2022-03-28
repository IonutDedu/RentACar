package RentACar.RentACar.repository;

import RentACar.RentACar.entity.Bike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends VehicleRepository{

    @Query(value = "SELECT * FROM vehicle , bike where vehicle.id  = bike.id", nativeQuery = true)
    List<Bike> getAllBikes();
}
