package nl.novi.Eindopdracht.dto.output;

import nl.novi.Eindopdracht.Models.Data.CarOwner;

import java.time.LocalDate;
import java.util.List;

public class CarOutputDto {
    public Long id;
    public String brand;
    public String model;
    public LocalDate yearOfBuild;
    public String color;
    public String licensePlate;
    public Integer mileage;
    public String engineType;
    public String body;
    public String transmission;
    public String fuel;

    public List<CarOwner> carOwners;

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getYearOfBuild() {
        return yearOfBuild;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Integer getMileage() {
        return mileage;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getBody() {
        return body;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearOfBuild(LocalDate yearOfBuild) {
        this.yearOfBuild = yearOfBuild;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
