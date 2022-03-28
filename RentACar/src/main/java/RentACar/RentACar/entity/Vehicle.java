package RentACar.RentACar.entity;


import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String brand;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private boolean isAvailable;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public void rentVehicle(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }

}
