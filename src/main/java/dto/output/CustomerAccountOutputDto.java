package dto.output;

public class CustomerAccountOutputDto {
    public static class CustomerAccountAllOutputDto {
        public Long id;
        public String costumerFirstName;
        public String costumerLastName;
        public String CostumerNumber;
        public String address;
        public String phoneNumber;
        public String billingAddress;
        public String bankAccountNumber;
    }
    public static class CustomerNameOutputDto {

        public String customerFirstName;
        public String customerLastname;
    }


    public static class CustomerFinanceOutputDto{

        public String billingAddress;
        public String bankAccountNumber;
    }

    public static class  CustomerAddressoutputDto{

        public String Address;
        public String billingAddress;
    }
}