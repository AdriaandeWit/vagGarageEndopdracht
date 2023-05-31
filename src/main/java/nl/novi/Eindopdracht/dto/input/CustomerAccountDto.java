package nl.novi.Eindopdracht.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccountDto {

    public Long id;
    public String customerName;
    public String firstName;
    public String lastName;
    public String address;
    public String phoneNumber;
    public String billingAddress;
    public String bankAccountNumber;


}
