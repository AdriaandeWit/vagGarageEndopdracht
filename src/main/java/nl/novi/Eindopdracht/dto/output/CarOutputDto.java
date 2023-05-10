package nl.novi.Eindopdracht.dto.output;

import lombok.Getter;
import lombok.Setter;
import nl.novi.Eindopdracht.Models.Data.CarBrand;
import nl.novi.Eindopdracht.Models.Data.CarModel;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;


import java.time.LocalDate;
@Getter
@Setter

public class CarOutputDto {
    public Long id;
    public CarBrand brand;

    public CarModel model;
    public LocalDate yearOfBuild;
    public String color;
    public String licensePlate;
    public Integer mileage;
    public String engineType;
    public String body;
    public String transmission;
    public String fuel;

    public CustomerAccount account;

}
