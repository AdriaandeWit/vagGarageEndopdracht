package Models.Data;

import jakarta.persistence.*;

@Entity
public class CarOwner {
    @EmbeddedId
    private CarOwnerKey id;


    // Dit is de owner kan van de relatie. Er staat een foreign key in de database
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("carId")
    @JoinColumn(name = "car_id")
    private Car car;

    // Dit is de owner kan van de relatie. Er staat een foreign key in de database
    @ManyToOne
    @MapsId("ownerId")
    @JoinColumn(name = "owner_id")
    private CustomerAccount customerAccount;

    public CarOwnerKey getId() {
        return id;
    }

    public void setId(CarOwnerKey id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }
}



