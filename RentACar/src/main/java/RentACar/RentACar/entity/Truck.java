package RentACar.RentACar.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Truck extends Vehicle{
    @Column
    private String fuel;

    @Column
    private long capacity;

    @Column
    private String traction;

    @Column
    private boolean trailer;

    @Column(unique = true, nullable = false)
    private String VIN;
}
