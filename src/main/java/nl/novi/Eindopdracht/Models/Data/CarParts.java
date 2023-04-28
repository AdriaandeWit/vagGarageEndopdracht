package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class CarParts {
@Id
@GeneratedValue
    private Long id;
    private String partName;
    private String partNumber;
    private Double price;
    private Integer amountOfParts;


//----------------------Getters

    public Long getId() {
        return id;
    }

    public String getPartName() {
        return partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAmountOfParts() {
        return amountOfParts;
    }


    //---------------Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAmountOfParts(Integer amountOfParts) {
        this.amountOfParts = amountOfParts;
    }
}
