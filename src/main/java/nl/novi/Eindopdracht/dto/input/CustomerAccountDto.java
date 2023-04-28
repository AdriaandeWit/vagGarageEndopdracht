package nl.novi.Eindopdracht.dto.input;

public class CustomerAccountDto {


    public static class CustomerAccountAllDto {
    public Long id;
    public String costumerFirstName;
    public String costumerLastName;
    public String CostumerNumber;
    public String address;
    public String phoneNumber;
    public String billingAddress;
    public String bankAccountNumber;
}
    public static class CustomerNameDto {

        public String customerFirstName;
        public String customerLastname;
    }
    public static class CustomerFinanceDto {

        public String billingAddress;
        public String bankAccountNumber;
    }

    public static class  CustomerAddressDto{

        public String Address;
        public String billingAddress;
    }

}
