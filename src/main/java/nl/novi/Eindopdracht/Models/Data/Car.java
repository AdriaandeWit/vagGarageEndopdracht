package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.novi.Eindopdracht.Models.Data.Enum.*;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "car")
public class Car {


    private CarBrand brand;
    private CarModel model;
    private LocalDate yearOfBuild;
    private Colors color;
    @Id
    private String licensePlate;
    private Integer mileAge;
    private EngineType engineType;
    private Body body;
    private Transmission transmission;
    private Fuel fuel;

    @ManyToOne
    private CustomerAccount account;

    @OneToOne(mappedBy = "carInspection")
    CarInspection carInspection;


}


