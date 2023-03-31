package Models;

public class CarParts {

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
