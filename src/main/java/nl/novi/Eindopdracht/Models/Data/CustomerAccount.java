package nl.novi.Eindopdracht.Models.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customerName", "customerNumber"}),
        @UniqueConstraint(columnNames = {"phoneNumber"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerAccount{
@GeneratedValue
    private Long id;
@Id         // TODO: 08/05/2023 vraag aan mark of je een een string met een long gekoppeld kan worden.
    private String customerName;

    private String firstName;
    private String lastName;

    private String customerNumber;
    private String address;
    private String phoneNumber;
    private String billingAddress;
    private String bankAccountNumber;

    @OneToMany
    @JsonIgnore
    List<CarOwner> carOwners;



}
