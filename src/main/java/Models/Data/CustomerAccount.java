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
    private String customerFirstName;
    private String customerLastname;
    private String CustomerNumber;
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

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastname;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
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

    public List<CarOwner> getCarOwners() {
        return carOwners;
    }
//----------------Setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerLastName(String costumerLastName) {
        this.customerLastname = costumerLastName;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
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

    public void setCarOwners(List<CarOwner> carOwners) {
        this.carOwners = carOwners;
    }
}
