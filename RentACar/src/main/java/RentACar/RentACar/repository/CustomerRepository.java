package RentACar.RentACar.repository;

import RentACar.RentACar.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE vehicle SET customer_id = NULL, isAvailable = 1 where customer_id =:customerId AND id =:vehicleId", nativeQuery = true)
    void retrieveVehicle(@Param("customerId") Long customerId, @Param("vehicleId") Long vehicleId);

}
