package Models.Data;

import java.time.LocalDate;

public class CarReparation {

private Long id;
private String Car;
private String carproblem;
private LocalDate repairDate;
private Double partCost;
private Double laborCost;
private Double totalCost;



//-------------Getters


    public Long getId() {
        return id;
    }

    public String getCar() {
        return Car;
    }

    public String getCarproblem() {
        return carproblem;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public Double getPartCost() {
        return partCost;
    }

    public Double getLaborCost() {
        return laborCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }


    //--------------Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setCar(String car) {
        Car = car;
    }

    public void setCarproblem(String carproblem) {
        this.carproblem = carproblem;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public void setPartCost(Double partCost) {
        this.partCost = partCost;
    }

    public void setLaborCost(Double laborCost) {
        this.laborCost = laborCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
