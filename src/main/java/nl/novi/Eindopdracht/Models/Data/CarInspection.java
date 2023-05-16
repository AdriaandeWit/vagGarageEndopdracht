package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "carInspection")
public class CarInspection {
@Id
@GeneratedValue
    private Long id;
    private int mileAge;

    private String licensePlate;
    private LocalDate inspectionDate;
    private boolean carIsCorrect;
    private String carIsFine;
    private String hasProblem;

    @OneToOne(mappedBy ="Car")
    private Car Car;

    @OneToMany
    private List<CarRepair> carRepair;



}




