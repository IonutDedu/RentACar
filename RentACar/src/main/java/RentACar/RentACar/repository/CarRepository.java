package RentACar.RentACar.repository;

import RentACar.RentACar.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends VehicleRepository{

    @Query (value = "SELECT * FROM vehicle , car where vehicle.id  = car.id", nativeQuery = true)
    List<Car> getAllCars();

    @Query (value = "SELECT * FROM vehicle , car where vehicle.id  = car.id AND isAvailable = true", nativeQuery = true)
    List<Car> getAllAvailableCars();
}
