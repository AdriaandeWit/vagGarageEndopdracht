package nl.novi.Eindopdracht.Models.Data.CarParts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

@Entity
@Table
public class SparkPlug extends CarParts {
    private  int spannerSize;
    private String quality;
    private int warmthDegree;
    private Double threadLenght;
    private int torque;
    private int sparkPosition;


}
