package nl.novi.Eindopdracht.Models.Data.CarParts;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Tyres extends CarParts {

    private Double tyresHight;
    private Double tyresWidth;
    private int Diameter;
    private String loadIndex;
    private String speedIndex;
    private Date productionDate;

    public Tyres() {
        super();
    }

    public Tyres(Long id, String partName, String partNumber, Double price, Integer amountOfParts, Double tyresHight, Double tyresWidth, int diameter, String loadIndex, String speedIndex, Date productionDate) {
        super(id, partName, partNumber, price, amountOfParts);
        this.tyresHight = tyresHight;
        this.tyresWidth = tyresWidth;
        this.Diameter = diameter;
        this.loadIndex = loadIndex;
        this.speedIndex = speedIndex;
        this.productionDate = productionDate;
    }

    public Double getTyresHight() {
        return tyresHight;
    }

    public Double getTyresWidth() {
        return tyresWidth;
    }

    public int getDiameter() {
        return Diameter;
    }

    public String getLoadIndex() {
        return loadIndex;
    }

    public String getSpeedIndex() {
        return speedIndex;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setTyresHight(Double tyresHight) {
        this.tyresHight = tyresHight;
    }

    public void setTyresWidth(Double tyresWidth) {
        this.tyresWidth = tyresWidth;
    }

    public void setDiameter(int diameter) {
        Diameter = diameter;
    }

    public void setLoadIndex(String loadIndex) {
        this.loadIndex = loadIndex;
    }

    public void setSpeedIndex(String speedIndex) {
        this.speedIndex = speedIndex;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

}
