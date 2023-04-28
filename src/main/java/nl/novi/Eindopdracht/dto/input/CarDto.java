package nl.novi.Eindopdracht.dto.input;

import nl.novi.Eindopdracht.Models.Data.CarOwner;

import java.time.LocalDate;
import java.util.List;

public class CarDto {

    public Long id;
    public String brand;
    public String model;
    public LocalDate yearOfBuild;
    public String color;
    public String licensePlate;
    public Integer mileAge;
    public String engineType;
    public String body;
    public String transmission;
    public String fuel;

    public List<CarOwner> carOwners;
}
