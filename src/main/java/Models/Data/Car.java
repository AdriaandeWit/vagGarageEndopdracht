package Models.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private LocalDate yearOfBuild;
    private String color;
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



    //-------------------Getters


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

    public List<CarOwner> getCarOwner() {
        return carOwner;
    }
//-------------Setters


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
    public void setCarOwner(List<CarOwner> carOwner) {
        this.carOwner = carOwner;
    }

}
