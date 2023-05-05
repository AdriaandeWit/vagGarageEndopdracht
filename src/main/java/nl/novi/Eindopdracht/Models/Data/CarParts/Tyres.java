package nl.novi.Eindopdracht.Models.Data.CarParts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

@Entity
@Table
public class Tyres extends CarParts {

    private Double tyresHight;
    private Double tyresWidth;
    private int Diameter;
    private String loadIndex;
    private String speedIndex;
    private Date productionDate;

}
