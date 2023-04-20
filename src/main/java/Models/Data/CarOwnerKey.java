package Models.Data;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class CarOwnerKey implements Serializable {
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "owner_Id")
    private Long ownerId;

    public CarOwnerKey() {}
    public CarOwnerKey(Long carId, Long ownerId) {
        this.carId = carId;
        this.ownerId = ownerId;
    }

    public Long getCarId() {
        return carId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        CarOwnerKey that = (CarOwnerKey) o;
        return carId.equals(that.carId)&& ownerId.equals(that.carId);
    }

    @Override
    public int hashCode() {return Objects.hash(carId, ownerId);}
}



