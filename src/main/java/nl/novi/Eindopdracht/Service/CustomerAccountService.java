package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;
import nl.novi.Eindopdracht.Repository.CarOwnerRepository;
import nl.novi.Eindopdracht.Repository.CustomerAccountRepository;
import nl.novi.Eindopdracht.dto.input.CustomerAccountDto;
import nl.novi.Eindopdracht.dto.output.CustomerAccountOutputDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerAccountService {


    private final CustomerAccountRepository cARepos;

    public CustomerAccountService(CustomerAccountRepository cARepos,CarOwnerRepository carOwnerRepos) {
        this.cARepos = cARepos;
    }


    public Long createCostumer(CustomerAccountDto.CustomerAccountAllDto cADto) {
        CustomerAccount account = DtoToAccount(cADto);

        cARepos.save(account);
        return account.getId();
    }

    public List<CustomerAccountOutputDto> getAllCustomers() {
        List<CustomerAccountOutputDto> collection = new ArrayList<>();
        List<CustomerAccount> list = cARepos.findAll();
        for (CustomerAccount account: list){
            collection.add(accountToDTo1(account));
        }
        return collection;
    }

    public CustomerAccountOutputDto getCustomerById(long id) {
        Optional<CustomerAccount> account = cARepos.findById(id);
        if (!account.isPresent()){
            throw new RecordNotFoundException("cannot find customer please enter a new id ");
        }
        else {
            CustomerAccount a = account.get();
            return accountToDTo1(a);
        }
    }

    public CustomerAccountOutputDto.CustomerNameOutputDto getCustomerByLastName(String customerLastName) {
        Optional<List<CustomerAccount>> optionalAccounts = cARepos.findByLastName(customerLastName);
        if(!optionalAccounts.isPresent()){
            throw new RecordNotFoundException("cannot find customer please enter a anther name");
        }
        else {
            CustomerAccount a = (CustomerAccount) optionalAccounts.get();
            return accountToDTo2(a);
        }

    }

    public CustomerAccountOutputDto.CustomerFinanceOutputDto getBillingAddressById(long id) {
        Optional<CustomerAccount>accountOptional = cARepos.findById(id);
        if (!accountOptional.isPresent()){
            throw  new RecordNotFoundException("cannot find the billing address so please enter a anther id");
        }
        else{
            CustomerAccount a = accountOptional.get();
            return accountToDTo3(a);
        }
    }

    public CustomerAccountDto.CustomerNameDto updateCustomerName(long id, String firstName, String LastName) {
            Optional<CustomerAccount> accountOptional = cARepos.findById(id);

            if (!accountOptional.isPresent()){
                throw new RecordNotFoundException("Can not find "+ firstName + LastName + "so please enter a anther id ");
            }
            else {
                CustomerAccount name = accountOptional.get();
                name.setFirstName(firstName);
                name.setLastName(LastName);
                cARepos.save(name);
                return null;
            }


    }

    public CustomerAccountDto.CustomerFinanceDto updateFinance(long id, String billingAdress, String bankAccountNumber) {
        Optional<CustomerAccount> accountOptional =cARepos.findById(id);
        if(!accountOptional.isPresent()){
            throw new RecordNotFoundException("cannot find the files, please give me anther id");
        }
        else {
            CustomerAccount a =accountOptional.get();
            a.setBankAccountNumber(bankAccountNumber);
            a.setBillingAddress(billingAdress);
            cARepos.save(a);
            return null;
        }
    }

    public void deleteCustomerById(long id) {
        cARepos.deleteById(id);
    }

    public void deleteAllCustomers() {
        cARepos.deleteAll();
    }

    public CustomerAccountOutputDto accountToDTo1(CustomerAccount account) {
        CustomerAccountOutputDto dto = new CustomerAccountOutputDto();

        dto.id = account.getId();
        dto.customerName = account.getCustomerName();
        dto.firstName = account.getFirstName();
        dto.lastName = account.getLastName();
        dto.customerNumber= account.getCustomerNumber();
        dto.address = account.getAddress();
        dto.phoneNumber =account.getPhoneNumber();
        dto.billingAddress = account.getBillingAddress();
        dto.bankAccountNumber =account.getBankAccountNumber();

        return dto;
    }
    public CustomerAccountOutputDto.CustomerNameOutputDto accountToDTo2(CustomerAccount account) {
        CustomerAccountOutputDto.CustomerNameOutputDto dto = new CustomerAccountOutputDto.CustomerNameOutputDto();


        dto.firstName = account.getFirstName();
        dto.lastName = account.getLastName();


        return dto;
    }
    public CustomerAccountOutputDto.CustomerFinanceOutputDto accountToDTo3(CustomerAccount account) {
        CustomerAccountOutputDto.CustomerFinanceOutputDto dto = new CustomerAccountOutputDto.CustomerFinanceOutputDto();

        dto.billingAddress = account.getBillingAddress();
        dto.bankAccountNumber = account.getBankAccountNumber();

        return dto;
    }

    public CustomerAccount DtoToAccount(CustomerAccountDto.CustomerAccountAllDto accountDto){
        CustomerAccount account =new CustomerAccount();

            account.setCustomerName(accountDto.customerName);
            account.setFirstName(accountDto.firstName);
            account.setLastName(accountDto.lastName);
            account.setCustomerNumber(accountDto.costumerNumber);
            account.setAddress(accountDto.address);
            account.setPhoneNumber(accountDto.phoneNumber);
            account.setBillingAddress(accountDto.billingAddress);
            account.setBankAccountNumber(accountDto.bankAccountNumber);


        return account;
    }



}
