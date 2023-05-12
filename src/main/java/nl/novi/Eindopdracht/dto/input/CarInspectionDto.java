package nl.novi.Eindopdracht.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CarInspectionDto {

    public Long id;
    public int milleAge;
    public String licensePlate;
    public String costumerNumber;
    public LocalDate inspectionDate;
    public boolean carIsCorrect;
    public String carIsFine;
    public boolean carIsIncorrect;
    public String hasProblem;

}
