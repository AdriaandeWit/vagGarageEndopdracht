package nl.novi.Eindopdracht.Models.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Costomer",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CUSTOMER_NAME", "CUSTOMER_NUMBER"}),
        @UniqueConstraint(columnNames = {"CUSTOMER_PHONE_NUMBER"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerAccount {
@GeneratedValue
    private Long id;
@Id

    private String customerNam;

    private String firstName;
    private String lastName;

    private String customerNumber;
    private String customerPhoneNumber;
    private String address;
    private String phoneNumber;
    private String billingAddress;
    private String bankAccountNumber;

    @OneToMany
    @JsonIgnore
    List<CarOwner> carOwners;



}
