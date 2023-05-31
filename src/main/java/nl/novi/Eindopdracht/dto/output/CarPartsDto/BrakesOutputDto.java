package nl.novi.Eindopdracht.dto.output.CarPartsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrakesOutputDto extends CarPartsOutputDto {

    public Double OuterDiameter;
    public Double centerDiameter;
    public Double Height;
    public Double minThickness;
    public Double surface;
    public Double discThickness;
    public String boreTypeNumberOfHoles;
    public Double wheelStudDiameter;
    public Boolean withoutWheelMountingBolts;
    public Boolean withoutWheelHub;

}
