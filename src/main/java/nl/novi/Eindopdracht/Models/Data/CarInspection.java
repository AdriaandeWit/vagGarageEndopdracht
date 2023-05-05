package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table
public class CarInspection {
@Id
@GeneratedValue
    private Long id;
    private int mileAge;

    private String licensePlate;
    private String costumerNumber;
    private LocalDate inspectionDate;

    private boolean carIsCorrect;
    private String carIsFine;
    private boolean carIsIncorrect;

    private String hasProblem;

}




