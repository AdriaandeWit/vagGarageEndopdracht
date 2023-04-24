package Controllers;

import Service.CustumerAccountService;
import dto.input.CustomerAccountDto;
import dto.output.CustomerAccountOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("customer")

public class CustomerAccountController {

    private final CustumerAccountService cAService;

    public CustomerAccountController(CustumerAccountService cAService) {
        this.cAService = cAService;
    }

    @PostMapping()
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerAccountDto.CustomerAccountAllDto cADto){
        Long id = cAService.createCostumer(cADto);
        cADto.id = id;


        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/"+ id).toUriString());

        return ResponseEntity.created(uri).body(cADto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerAccountOutputDto.CustomerAccountAllOutputDto>> getAllCustemers(){
        List<CustomerAccountOutputDto.CustomerAccountAllOutputDto> customers = cAService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerAccountOutputDto.CustomerAccountAllOutputDto > getCustomerById(@PathVariable long id ){
        CustomerAccountOutputDto.CustomerAccountAllOutputDto customer = cAService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/{ownername}")
    public ResponseEntity<CustomerAccountOutputDto.CustomerNameOutputDto> getCustomerByName(@PathVariable String costumerfirstname){
        CustomerAccountOutputDto.CustomerNameOutputDto customer = cAService.getCustomerByName(costumerfirstname);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/billingaddress/{id}")
    public ResponseEntity<CustomerAccountOutputDto.CustomerFinanceOutputDto>getBillingAddressById(@PathVariable long id){
        CustomerAccountOutputDto.CustomerFinanceOutputDto customer = cAService.getBillingAddressById(id);
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/find/car/{id}")
    public ResponseEntity<CustomerAccountOutputDto.CustomerAccountAllOutputDto>getCarById(@PathVariable long id){
        customerCar = cAService.getCarById(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/update/name/{id}")
    public ResponseEntity<CustomerAccountDto.CustomerNameDto> updateCustomerName(@PathVariable long id, @RequestParam String customerFirstname, @RequestParam String customerLastName){

        CustomerAccountDto.CustomerNameDto customer =  cAService.updateCustomerName(id,customerFirstname,customerLastName);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/update/address/{id}")
    public ResponseEntity<CustomerAccountDto.CustomerFinanceDto> updateFinance(@PathVariable long id, @RequestParam String billingAdress, @RequestParam String bankAccountNumber){
        CustomerAccountDto.CustomerFinanceDto customer = cAService.updateFinance(id,billingAdress,bankAccountNumber);
        return ResponseEntity.ok(customer);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable long id){
        cAService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllCustomers(){
        cAService.deleteAllCustomers();
        return ResponseEntity.noContent().build();

    }


}
