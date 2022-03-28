package RentACar.RentACar.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Bike extends Vehicle{
    @Column
    private String type;

    @Column
    private boolean frontSuspension;

    @Column
    private boolean rearSuspension;

    @Column
    private String speeds;
}
