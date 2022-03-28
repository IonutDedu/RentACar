package RentACar.RentACar.repository;

import RentACar.RentACar.entity.Vehicle;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
