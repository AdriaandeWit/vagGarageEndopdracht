package nl.novi.Eindopdracht.Models.Data.CarParts;


import jakarta.persistence.*;
import lombok.*;
import nl.novi.Eindopdracht.Models.Data.CarRepair;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CarParts {
    @Id
    @GeneratedValue
    @NonNull
    private Long id;
    @NonNull
    private String partName;
    @NonNull
     private String partNumber;
    @NonNull
    private Double price;
    @NonNull
    private Integer amountOfParts;


    @ManyToMany
    private List<CarRepair> carRepair;

}
