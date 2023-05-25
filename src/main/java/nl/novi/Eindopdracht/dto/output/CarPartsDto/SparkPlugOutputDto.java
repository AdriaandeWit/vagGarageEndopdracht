package nl.novi.Eindopdracht.dto.output.CarPartsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SparkPlugOutputDto extends CarPartsOutputDto {

    public int spannerSize;
    public String quality;
    public int warmthDegree;
    public Double threadLength;
    public int torque;
    public int sparkPosition;
}
