package RentACar.RentACar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column (unique = true)
    private String email;

    @Column
    private String driverLicence;

    @Column
    private String phoneNumber;

    @JsonIgnore
    @OneToMany (mappedBy = "customer")
    private List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }



}
