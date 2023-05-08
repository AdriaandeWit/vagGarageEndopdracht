package nl.novi.Eindopdracht.Models.Data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class CarOwner {
    @EmbeddedId
    private CarOwnerKey id;


    // Dit is de owner kan van de relatie. Er staat een foreign key in de database
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "car_id")
    private Car car;

    // Dit is de owner kan van de relatie. Er staat een foreign key in de database
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "owner_id")
    private CustomerAccount customerAccount;



}



