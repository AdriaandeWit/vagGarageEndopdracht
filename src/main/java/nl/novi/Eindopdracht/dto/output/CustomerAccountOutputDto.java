package nl.novi.Eindopdracht.dto.output;

public class CustomerAccountOutputDto {


    public Long id;
    public String customerFirstName;

    public String customerLastName;
    public String costumerNumber;
    public String address;
    public String phoneNumber;
    public String billingAddress;
    public String bankAccountNumber;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCostumerNumber() {
        return costumerNumber;
    }

    public void setCostumerNumber(String costumerNumber) {
        this.costumerNumber = costumerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}