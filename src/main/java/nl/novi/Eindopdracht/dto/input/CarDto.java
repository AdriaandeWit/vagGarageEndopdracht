package nl.novi.Eindopdracht.dto.input;

import nl.novi.Eindopdracht.Models.Data.CarBrand;
import nl.novi.Eindopdracht.Models.Data.CarModel;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;

import java.time.LocalDate;


public class CarDto {

    public Long id;
    public CarBrand brand;
    public CarModel model;
    public LocalDate yearOfBuild;
    public String color;
    public String licensePlate;
    public Integer mileAge;
    public String engineType;
    public String body;
    public String transmission;
    public String fuel;

    public CustomerAccount account;
}
