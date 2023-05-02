package nl.novi.Eindopdracht.Models.Data.CarParts;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Brakes extends CarParts{


private Double OuterDiameter;
private Double centerDiameter;
private Double Height;
private Double minThickness;
private Double surface;
private Double discThickness;
private String boreTypeNumberOfHoles;
private Double wheelStudDiameter;
private Boolean withoutWheelMountingBolts;
private Boolean withoutWheelHub;


    public Brakes() {
    super();
}

    public Brakes(Long id,String partName,String partNumber, Double price,Integer amountOfParts, Double outerDiameter,
                  Double centerDiameter, Double height, Double minThickness,
                  Double surface, Double discThickness, String boreTypeNumberOfHoles, Double wheelStudDiameter,
                  Boolean withoutWheelMountingBolts, Boolean withoutWheelHub) {
        super(id,partName,partNumber,price,amountOfParts);
        this.OuterDiameter = outerDiameter;
        this.centerDiameter = centerDiameter;
        this.Height = height;
        this.minThickness = minThickness;
        this.surface = surface;
        this.discThickness = discThickness;
        this.boreTypeNumberOfHoles = boreTypeNumberOfHoles;
        this.wheelStudDiameter = wheelStudDiameter;
        this.withoutWheelMountingBolts = withoutWheelMountingBolts;
        this.withoutWheelHub = withoutWheelHub;
    }



    public Double getOuterDiameter() {
        return OuterDiameter;
    }

    public Double getCenterDiameter() {
        return centerDiameter;
    }

    public Double getHeight() {
        return Height;
    }

    public Double getMinThickness() {
        return minThickness;
    }

    public Double getSurface() {
        return surface;
    }

    public Double getDiscThickness() {
        return discThickness;
    }

    public String getBoreTypeNumberOfHoles() {
        return boreTypeNumberOfHoles;
    }

    public Double getWheelStudDiameter() {
        return wheelStudDiameter;
    }

    public Boolean getWithoutWheelMountingBolts() {
        return withoutWheelMountingBolts;
    }

    public Boolean getWithoutWheelHub() {
        return withoutWheelHub;
    }

    public void setOuterDiameter(Double outerDiameter) {
        OuterDiameter = outerDiameter;
    }

    public void setCenterDiameter(Double centerDiameter) {
        this.centerDiameter = centerDiameter;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public void setMinThickness(Double minThickness) {
        this.minThickness = minThickness;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public void setDiscThickness(Double discThickness) {
        this.discThickness = discThickness;
    }

    public void setBoreTypeNumberOfHoles(String boreTypeNumberOfHoles) {
        this.boreTypeNumberOfHoles = boreTypeNumberOfHoles;
    }

    public void setWheelStudDiameter(Double wheelStudDiameter) {
        this.wheelStudDiameter = wheelStudDiameter;
    }

    public void setWithoutWheelMountingBolts(Boolean withoutWheelMountingBolts) {
        this.withoutWheelMountingBolts = withoutWheelMountingBolts;
    }

    public void setWithoutWheelHub(Boolean withoutWheelHub) {
        this.withoutWheelHub = withoutWheelHub;
    }

}
