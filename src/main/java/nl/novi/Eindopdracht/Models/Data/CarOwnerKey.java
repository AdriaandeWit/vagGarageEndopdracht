package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Embeddable
public class CarOwnerKey implements Serializable {
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "owner_Id")
    private Long ownerId;

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



