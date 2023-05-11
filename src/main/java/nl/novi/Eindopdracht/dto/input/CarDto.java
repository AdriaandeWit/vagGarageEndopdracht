package nl.novi.Eindopdracht.dto.input;

import nl.novi.Eindopdracht.Models.Colors;
import nl.novi.Eindopdracht.Models.Data.*;

import java.time.LocalDate;


public class CarDto {

    public Long id;
    public CarBrand brand;
    public CarModel model;
    public LocalDate yearOfBuild;
    public Colors color;
    public String licensePlate;
    public Integer mileAge;
    public EngineType engineType;
    public Body body;
    public Transmission transmission;
    public Fuel fuel;

    public CustomerAccount account;


}
