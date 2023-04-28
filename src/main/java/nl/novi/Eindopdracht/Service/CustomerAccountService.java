package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;
import nl.novi.Eindopdracht.Repository.CarOwnerRepository;
import nl.novi.Eindopdracht.Repository.CustomerAccountRepository;
import nl.novi.Eindopdracht.dto.input.CustomerAccountDto;
import nl.novi.Eindopdracht.dto.output.CustomerAccountOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerAccountService {

@Autowired
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
        if (account.isEmpty()){
            throw new RecordNotFoundException("cannot find customer please enter a new id ");
        }
        else {
            CustomerAccount a = account.get();
            return accountToDTo1(a);
        }
    }

    public CustomerAccountOutputDto.CustomerNameOutputDto getCustomerByName(String customerFirstname) {
        Optional<CustomerAccount>accountOptional = cARepos.findbyNameStarteingWith(customerFirstname);
        if(accountOptional.isEmpty()){
            throw new RecordNotFoundException("cannot find customer please enter a anther name");
        }
        else {
            CustomerAccount a = accountOptional.get();
            return accountToDTo2(a);
        }

    }

    public CustomerAccountOutputDto.CustomerFinanceOutputDto getBillingAddressById(long id) {
        Optional<CustomerAccount>accountOptional = cARepos.findById(id);
        if (accountOptional.isEmpty()){
            throw  new RecordNotFoundException("cannot find the billing address so please enter a anther id");
        }
        else{
            CustomerAccount a = accountOptional.get();
            return accountToDTo3(a);
        }
    }

    public CustomerAccountDto.CustomerNameDto updateCustomerName(long id, String customerFirstname, String customerLastName) {
            Optional<CustomerAccount> accountOptional = cARepos.findById(id);

            if (accountOptional.isEmpty()){
                throw new RecordNotFoundException("Can not find "+ customerFirstname + customerLastName+ "so please enter a anther id ");
            }
            else {
                var name = accountOptional.get();
                name.setCustomerFirstName(customerFirstname);
                name.setCustomerLastName(customerLastName);
                cARepos.save(name);
                return null;
            }


    }

    public CustomerAccountDto.CustomerFinanceDto updateFinance(long id, String billingAdress, String bankAccountNumber) {
        Optional<CustomerAccount> accountOptional =cARepos.findById(id);
        if(accountOptional.isEmpty()){
            throw new RecordNotFoundException("cannot find the files, please give me anther id");
        }
        else {
            var a =accountOptional.get();
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
        dto.customerFirstName = account.getCustomerFirstName();
        dto.customerLastName = account.getCustomerLastName();
        dto.costumerNumber = account.getCustomerNumber();
        dto.address = account.getAddress();
        dto.phoneNumber =account.getPhoneNumber();
        dto.billingAddress = account.getBillingAddress();
        dto.bankAccountNumber =account.getBankAccountNumber();

        return dto;
    }
    public CustomerAccountOutputDto.CustomerNameOutputDto accountToDTo2(CustomerAccount account) {
        CustomerAccountOutputDto.CustomerNameOutputDto dto = new CustomerAccountOutputDto.CustomerNameOutputDto();


        dto.customerFirstName = account.getCustomerFirstName();
        dto.customerLastname = account.getCustomerLastName();


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

        account.setCustomerFirstName(accountDto.costumerFirstName);
        account.setCustomerLastName(accountDto.costumerLastName);
        account.setCustomerNumber(accountDto.CostumerNumber);
        account.setAddress(accountDto.address);
        account.setPhoneNumber(accountDto.phoneNumber);
        account.setBillingAddress(accountDto.billingAddress);
        account.setBankAccountNumber(accountDto.bankAccountNumber);

        return account;
    }



}
