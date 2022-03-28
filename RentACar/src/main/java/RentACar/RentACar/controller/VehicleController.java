package RentACar.RentACar.controller;
import RentACar.RentACar.entity.*;
import RentACar.RentACar.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VehicleController {

    private static final Logger logger = LogManager.getLogger(VehicleController.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private CustomerRepository customerRepository;


    // test for postman
    @GetMapping("/test")
    public String testApp() {
        return "TestApp OK!";
    }

    //------------------------------------CAR--------------------------------//

    // add a car to DB
    @PostMapping(value = "/add-car")
    public ResponseEntity<Vehicle> addCar(@RequestBody Car car) {
        try {
            return new ResponseEntity<>(vehicleRepository.save(car), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Car {} already exists ", car.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //update car by id
    @PutMapping(value = "/update-car/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody Car car) {
        try {
            Car carUpdated = (Car) carRepository.findById(id).get();
            carUpdated.setBrand(car.getBrand());
            carUpdated.setModel(car.getModel());
            carUpdated.setColor(car.getColor());
            carUpdated.setAvailable(car.isAvailable());
            carUpdated.setFuel(car.getFuel());
            carUpdated.setBodyType(car.getBodyType());
            carUpdated.setTraction(car.getTraction());
            carUpdated.setAirConditioner(car.isAirConditioner());
            carUpdated.setBabySeat(car.isBabySeat());
            carUpdated.setVIN(car.getVIN());
            carRepository.save(carUpdated);
            return new ResponseEntity<>((Car) carRepository.findById(id).get(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Car {} with this VIN already exists ", car.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // delete car by id
    @DeleteMapping(value = "/delete-car/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable long id) {
        try {
            carRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            logger.error("Car {} doesn't exists ", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //------------------------------------------BIKE-------------------------------------//

    // add a bike to DB
    @PostMapping(value = "/add-bike")
    public ResponseEntity<Vehicle> addBike(@RequestBody Bike bike) {
        try {
            return new ResponseEntity<>(vehicleRepository.save(bike), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Bike {} already exists ", bike.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //update bike by id
    @PutMapping(value = "/update-bike/{id}")
    public ResponseEntity<Bike> updateBike(@PathVariable long id, @RequestBody Bike bike) {
        try {
            Bike bikeUpdated = (Bike) bikeRepository.findById(id).get();
            bikeUpdated.setBrand(bike.getBrand());
            bikeUpdated.setModel(bike.getModel());
            bikeUpdated.setColor(bike.getColor());
            bikeUpdated.setAvailable(bike.isAvailable());
            bikeUpdated.setType(bike.getType());
            bikeUpdated.setFrontSuspension(bike.isFrontSuspension());
            bikeUpdated.setRearSuspension(bike.isRearSuspension());
            bikeUpdated.setSpeeds(bike.getSpeeds());
            bikeRepository.save(bikeUpdated);
            return new ResponseEntity<>((Bike) bikeRepository.findById(id).get(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Bike {} already exists ", bike.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // delete bike by id
    @DeleteMapping(value = "/delete-bike/{id}")
    public ResponseEntity<Void> deleteBike(@PathVariable long id) {
        try {
            bikeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            logger.error("Bike {} doesn't exists ", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //------------------------------------------TRUCK-------------------------------------//

    // add a truck to DB
    @PostMapping(value = "/add-truck")
    public ResponseEntity<Vehicle> addTruck(@RequestBody Truck truck) {
        try {
            return new ResponseEntity<>(vehicleRepository.save(truck), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("truck {} already exists ", truck.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //update truck by id
    @PutMapping(value = "/update-truck/{id}")
    public ResponseEntity<Truck> updateTruck(@PathVariable long id, @RequestBody Truck truck) {
        try {
            Truck truckUpdated = (Truck) truckRepository.findById(id).get();
            truckUpdated.setBrand(truck.getBrand());
            truckUpdated.setModel(truck.getModel());
            truckUpdated.setColor(truck.getColor());
            truckUpdated.setAvailable(truck.isAvailable());
            truckUpdated.setFuel(truck.getFuel());
            truckUpdated.setCapacity(truck.getCapacity());
            truckUpdated.setTraction(truck.getTraction());
            truckUpdated.setTrailer(truck.isTrailer());
            truckUpdated.setVIN(truck.getVIN());
            truckRepository.save(truckUpdated);
            return new ResponseEntity<>((Truck) truckRepository.findById(id).get(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Truck {} already exists ", truck.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // delete truck by id
    @DeleteMapping(value = "/delete-truck/{id}")
    public ResponseEntity<Void> deleteTruck(@PathVariable long id) {
        try {
            truckRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            logger.error("Truck {} doesn't exists ", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //------------------------------------------------------------------------------------//

    // retrieve all vehicles from DB
    @GetMapping(value = "/get-all-vehicles")
    public ResponseEntity<Iterable<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
    }

    // get all cars
    @GetMapping(value = "/get-all-cars")
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    // get all available cars
    @GetMapping(value = "/get-all-available-cars")
    public List<Car> getAllAvailableCars() {return carRepository.getAllAvailableCars();
    }

    // get all Bikes
    @GetMapping(value = "/get-all-bikes")
    public List<Bike> getAllBikes() {
        return bikeRepository.getAllBikes();
    }

    // get all Trucks
    @GetMapping(value = "/get-all-trucks")
    public List<Truck> getAllTrucks() {
        return truckRepository.getAllTrucks();
    }


    @PutMapping(value = "/{vehicleId}/customer/{customerId}")
    public ResponseEntity<Vehicle> assignVehicleToCustomer(@PathVariable Long vehicleId, @PathVariable Long customerId) {
        try {
            Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
            Customer customer = customerRepository.findById(customerId).get();
            if (vehicle.isAvailable() == false)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            else {
                vehicle.rentVehicle(customer);
                vehicle.setAvailable(false);
                return new ResponseEntity<>(vehicleRepository.save(vehicle), HttpStatus.OK);
            }
        } catch (DataIntegrityViolationException e) {
            logger.error("Vehicle {} already rented ", vehicleId);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/{customerId}/vehicle/{vehicleId}")
    public ResponseEntity<Vehicle> retrieveVehicle(@PathVariable Long customerId, @PathVariable Long vehicleId) {
        try {
            Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
            Customer customer = customerRepository.findById(customerId).get();
            customerRepository.retrieveVehicle(customerId, vehicleId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Vehicle {} not rented ", vehicleId);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
