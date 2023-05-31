package nl.novi.Eindopdracht.dto.input.CarPartsDto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class TyresDto extends CarPartsDto{

    public Double tyresHight;
    public Double tyresWidth;
    public int diameter;
    public String loadIndex;
    public String speedIndex;
    public Date productionDate;
}
