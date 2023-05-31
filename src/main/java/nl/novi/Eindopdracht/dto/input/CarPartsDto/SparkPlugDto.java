package nl.novi.Eindopdracht.dto.input.CarPartsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SparkPlugDto extends CarPartsDto{

    public   int spannerSize;
    public String quality;
    public int warmthDegree;
    public Double threadLength;
    public int torque;
    public int sparkPosition;
}
