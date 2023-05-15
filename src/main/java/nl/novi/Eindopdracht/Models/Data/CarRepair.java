package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.novi.Eindopdracht.Models.Data.CarParts.CarParts;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class CarRepair {
@Id
private Long id;
private String car;
private String carProblem;
private LocalDate repairDate;
private Double partCost;
private Double laborCost;
private Double totalCost;

@OneToMany
private CarParts carParts;


}
