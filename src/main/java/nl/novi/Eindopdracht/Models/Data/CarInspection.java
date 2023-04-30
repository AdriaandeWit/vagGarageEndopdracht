package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class CarInspection {
@Id
@GeneratedValue
    private Long id;
    private int mileAge;
    private String licensePlate;
    private String costumerNumber;
    private LocalDate inspectionDate;

    private boolean carIsCorrect;
    private String carIsFine;
    private boolean carIsIncorrect;

    private String hasProblem;




    public Long getId() {
        return id;
    }

    public int getMileAge() {
        return mileAge;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCostumerNumber() {
        return costumerNumber;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public boolean isCarIsCorrect() {
        return carIsCorrect;
    }

    public String getCarIsFine() {
        return carIsFine;
    }

    public boolean isCarIsIncorrect() {
        return carIsIncorrect;
    }

    public String getHasProblem() {
        return hasProblem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setCostumerNumber(String costumerNumber) {
        this.costumerNumber = costumerNumber;
    }

    public void setInspectionDate(LocalDate inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public void setCarIsCorrect(boolean carIsCorrect) {
        this.carIsCorrect = carIsCorrect;
    }

    public void setCarIsFine(String carIsFine) {
        this.carIsFine = carIsFine;
    }

    public void setCarIsIncorrect(boolean carIsIncorrect) {
        this.carIsIncorrect = carIsIncorrect;
    }

    public void setHasProblem(String hasProblem) {
        this.hasProblem = hasProblem;
    }
}




