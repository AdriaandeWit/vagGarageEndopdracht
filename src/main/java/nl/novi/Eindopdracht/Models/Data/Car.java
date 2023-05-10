package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.*;
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
@Table(name = "car")
public class Car {
    @GeneratedValue
    private Long id;
    private CarBrand brand;
    private CarModel model;
    private LocalDate yearOfBuild;
    private String color;
    @Id
    private String licensePlate;
    private Integer mileage;
    private String engineType;
    private String body;
    private String transmission;
    private String fuel;

  @ManyToOne
    private CustomerAccount account;


}
