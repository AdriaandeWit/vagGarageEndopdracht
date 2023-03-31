package Models;

import java.time.LocalDate;
import java.util.Date;

public class CarInspection {

    private Long id;
    private String ownersname;
    private String ownersPhoneNumber;
    private String costumerNumber;
    private LocalDate lastInspection;

    //---------------------------- Getters
    public Long getId() {
        return id;
    }

    public String getOwnersname() {
        return ownersname;
    }

    public String getOwnersPhoneNumber() {
        return ownersPhoneNumber;
    }

    public String getCostumerNumber() {
        return costumerNumber;
    }

    public LocalDate getLastInspection() {
        return lastInspection;
    }

    public void setId(Long id) {
        this.id = id;
    }

//-------------------------Setters

    public void setOwnersname(String ownersname) {
        this.ownersname = ownersname;
    }

    public void setOwnersPhoneNumber(String ownersPhoneNumber) {
        this.ownersPhoneNumber = ownersPhoneNumber;
    }

    public void setCostumerNumber(String costumerNumber) {
        this.costumerNumber = costumerNumber;
    }

    public void setLastInspection(LocalDate lastInspection) {
        this.lastInspection = lastInspection;
    }
}




