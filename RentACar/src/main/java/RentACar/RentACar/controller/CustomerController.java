package RentACar.RentACar.controller;

import RentACar.RentACar.entity.Customer;
import RentACar.RentACar.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement
public class CustomerController {
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/add-customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        try {
            return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Customer {} already exists ", customer.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update-customer/{id}")
    @Transactional
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        try {
            Customer customerUpdated = customerRepository.findById(id).get();
            customerUpdated.setFirstName(customer.getFirstName());
            customerUpdated.setLastName(customer.getLastName());
            customerUpdated.setEmail(customer.getEmail());
            customerUpdated.setDriverLicence(customer.getDriverLicence());
            customerUpdated.setPhoneNumber(customer.getPhoneNumber());
            return new ResponseEntity<>(customerRepository.findById(id).get(), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("Customer {} already exists ", customer.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete-customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long id) {
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DataIntegrityViolationException e) {
            logger.error("Customer {} doesn't exists ", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-all-customers")
    public ResponseEntity<Iterable<Customer>> getCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
