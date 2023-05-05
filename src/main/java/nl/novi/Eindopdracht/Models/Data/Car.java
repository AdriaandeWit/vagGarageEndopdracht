package nl.novi.Eindopdracht.Models.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "car")
public class Car {
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private LocalDate yearOfBuild;
    private String color;
    @Id
    private String licensePlate;
    private Integer mileage;
    private String engineType;
    private String body;
    private String transmission;
    private String fuel;



    @OneToMany(mappedBy = "car")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    List<CarOwner> carOwner;


}
