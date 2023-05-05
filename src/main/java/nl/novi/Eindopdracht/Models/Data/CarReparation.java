package nl.novi.Eindopdracht.Models.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarReparation {

private Long id;
private String Car;

private String carProblem;
private LocalDate repairDate;
private Double partCost;
private Double laborCost;
private Double totalCost;



}
