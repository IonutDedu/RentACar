package RentACar.RentACar.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Car extends Vehicle{

    @Column
    private String fuel;

    @Column
    private String bodyType;

    @Column
    private String traction;

    @Column
    private boolean airConditioner;

    @Column
    private boolean babySeat;

    @Column(unique = true, nullable = false)
    private String VIN;


}
