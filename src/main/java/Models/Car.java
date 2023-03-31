package Models;

import java.time.LocalDate;

public class Car {

    private Long id;
    private String brand;
    private String model;
    private LocalDate yearOfbuild;
    private String color;
    private String licensePlate;
    private Integer mileage;
    private String motorType;
    private String body;
    private String transmissie;
    private String fuel;




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

    public LocalDate getYearOfbuild() {
        return yearOfbuild;
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

    public String getMotorType() {
        return motorType;
    }

    public String getBody() {
        return body;
    }

    public String getTransmissie() {
        return transmissie;
    }

    public String getFuel() {
        return fuel;
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

    public void setYearOfbuild(LocalDate yearOfbuild) {
        this.yearOfbuild = yearOfbuild;
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

    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTransmissie(String transmissie) {
        this.transmissie = transmissie;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
