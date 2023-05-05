package nl.novi.Eindopdracht.Models.Data.CarParts;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
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
}
