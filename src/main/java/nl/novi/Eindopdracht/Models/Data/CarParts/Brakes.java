package nl.novi.Eindopdracht.Models.Data.CarParts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table
public class Brakes extends CarParts{


private Double outerDiameter;
private Double centerDiameter;
private Double height;
private Double minThickness;
private Double surface;
private Double discThickness;
private String boreTypeNumberOfHoles;
private Double wheelStudDiameter;
private Boolean withoutWheelMountingBolts;
private Boolean withoutWheelHub;





}
