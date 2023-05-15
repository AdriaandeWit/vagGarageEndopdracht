package nl.novi.Eindopdracht.Models.Data.CarParts;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.*;
import nl.novi.Eindopdracht.Models.Data.CarRepair;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class CarParts {
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

    @OneToMany
    private List<CarRepair> carRepair;

}
