package nl.novi.Eindopdracht.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class CarRepairDto {


    public Long id;
    public String Car;
    public String carProblem;
    public LocalDate repairDate;
    public Double partCost;
    public Double laborCost;
    public Double totalCost;


}
