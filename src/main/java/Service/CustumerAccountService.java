package Service;

import Models.Data.Car;
import Models.Data.CustomerAccount;
import Repository.CustomerAccountRepository;
import dto.input.CustomerAccountDto;
import dto.output.CustomerAccountOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustumerAccountService {

@Autowired
    private final CustomerAccountRepository cARepos;

    public CustumerAccountService(CustomerAccountRepository cARepos) {
        this.cARepos = cARepos;
    }


    public Long createCostumer(CustomerAccountDto.CustomerAccountAllDto cADto) {
        CustomerAccount account = DtoToAccount(cADto);

        cARepos.save(account);
        return account.getId();
    }

    public List<CustomerAccountOutputDto.CustomerAccountAllOutputDto> getAllCustomers() {
        List<CustomerAccountOutputDto.CustomerAccountAllOutputDto> collection = new ArrayList<>();
        List<CustomerAccount> list = cARepos.findAll();
        for (CustomerAccount account: list){
            collection.add(accountToDTo1(account));
        }
        return collection;
    }

    public CustomerAccountOutputDto.CustomerAccountAllOutputDto getCustomerById(long id) {
        Optional<CustomerAccount> account = cARepos.findById(id);
        if (account.isEmpty()){
            throw new //RecordnotFoundException
        }
        else {
            CustomerAccount a = account.get();
            return accountToDTo1(a);
        }
    }

    public CustomerAccountOutputDto.CustomerNameOutputDto getCustomerByName(String costumerfirstname) {
        Optional<CustomerAccount>accountOptional = cARepos.findbyNameStarteingWith(costumerfirstname);
        if(accountOptional.isEmpty()){
            throw new //recordnotFounException
        }
        else {
            CustomerAccount a = accountOptional.get();
            return accountToDTo2(a);
        }

    }

    public CustomerAccountOutputDto.CustomerFinanceOutputDto getBillingAddressById(long id) {
        Optional<CustomerAccount>accountOptional = cARepos.findById(id);
        if (accountOptional.isEmpty()){
            throw  new//
        }
        else{
            CustomerAccount a = accountOptional.get();
            return accountToDTo3(a);
        }
    }

    public Car getCarById(long id) {
        Optional<Object> car =cARepos.findById(id);
        if( car.isEmpty()){
            throw new
        }
        else {

        }
    }

    public CustomerAccountDto.CustomerNameDto updateCustomerName(long id, String customerFirstname, String customerLastName) {


    }

    public CustomerAccountDto.CustomerFinanceDto updateFinance(long id, String billingAdress, String bankAccountNumber) {
        Optional<CustomerAccount> accountOptional =cARepos.findById(id);
        if(accountOptional.isEmpty()){
            throw new
        }
        else {
            var a =accountOptional.get();
            a.setBankAccountNumber(bankAccountNumber);
            a.setBillingAddress(billingAdress);
            cARepos.save(a);
            return dtoTO
        }
    }

    public void deleteCustomerById(long id) {
        cARepos.deleteById(id);
    }

    public void deleteAllCustomers() {
        cARepos.deleteAll();
    }

    public CustomerAccountOutputDto.CustomerAccountAllOutputDto accountToDTo1(CustomerAccount account) {
        CustomerAccountOutputDto.CustomerAccountAllOutputDto dto = new CustomerAccountOutputDto.CustomerAccountAllOutputDto();

        dto.id = account.getId();
        dto.costumerFirstName = account.getCustomerFirstName();
        dto.costumerLastName = account.getCustomerLastName()
        dto.CostumerNumber= account.getCustomerNumber();
        dto.address = account.getAddress();
        dto.phoneNumber =account.getPhoneNumber();
        dto.billingAddress = account.getBillingAddress();
        dto.bankAccountNumber =account.getBankAccountNumber();

        return dto;
    }
    public CustomerAccountOutputDto.CustomerNameOutputDto accountToDTo2(CustomerAccount account) {
        CustomerAccountOutputDto.CustomerNameOutputDto dto = new CustomerAccountOutputDto.CustomerNameOutputDto();


        dto.costumerFirstName = account.getCustomerFirstName();
        dto.costumerLastName = account.getCustomerLastName();


        return dto;
    }
    public CustomerAccountOutputDto.CustomerFinanceOutputDto accountToDTo3(CustomerAccount account) {
        CustomerAccountOutputDto.CustomerFinanceOutputDto dto = new CustomerAccountOutputDto.CustomerFinanceOutputDto();

        dto.billingAddress = account.getBillingAddress();
        dto.bankAccountNumber = account.getBankAccountNumber()

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
