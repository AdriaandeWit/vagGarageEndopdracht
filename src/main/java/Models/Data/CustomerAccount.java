package Models.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class CustomerAccount {
@Id
@GeneratedValue
    private Long id;
    private String costumerFirstName;
    private String costumerLastName;
    private String CostumerNumber;
    private String address;
    private String phoneNumber;
    private String billingAddress;
    private String bankAccountNumber;


    @OneToMany
    @JsonIgnore
    List<CarOwner> carOwners;

/*
hier komt nog de relatie met car.

 */

    //--------------Getters


    public Long getId() {
        return id;
    }

    public String getCostumerFirstName() {
        return costumerFirstName;
    }

    public String getCostumerLastName() {
        return costumerLastName;
    }

    public String getCostumerNumber() {
        return CostumerNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    //----------------Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setCostumerFirstName(String costumerFirstName) {
        this.costumerFirstName = costumerFirstName;
    }

    public void setCostumerLastName(String costumerLastName) {
        this.costumerLastName = costumerLastName;
    }

    public void setCostumerNumber(String costumerNumber) {
        CostumerNumber = costumerNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
