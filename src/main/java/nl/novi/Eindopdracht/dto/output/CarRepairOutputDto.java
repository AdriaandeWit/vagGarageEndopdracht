package nl.novi.Eindopdracht.dto.output;

import java.time.LocalDate;

public class CarRepairOutputDto {

    public Long id;
    public String Car;
    public String carProblem;
    public LocalDate repairDate;
    public Double partCost;
    public Double laborCost;
    public Double totalCost;
}
