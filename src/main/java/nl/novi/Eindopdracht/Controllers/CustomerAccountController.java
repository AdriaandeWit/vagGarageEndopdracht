package nl.novi.Eindopdracht.Controllers;

import nl.novi.Eindopdracht.Service.CarOwnerService;
import nl.novi.Eindopdracht.Service.CustomerAccountService;
import nl.novi.Eindopdracht.dto.input.CustomerAccountDto;
import nl.novi.Eindopdracht.dto.output.CarOutputDto;
import nl.novi.Eindopdracht.dto.output.CustomerAccountOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RequestMapping("customer")

public class CustomerAccountController {

    private final CustomerAccountService cAService;

    private final CarOwnerService carOwnerService;

    public CustomerAccountController(CustomerAccountService cAService, CarOwnerService carOwnerService) {
        this.cAService = cAService;
        this.carOwnerService = carOwnerService;
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
    public ResponseEntity<List<CustomerAccountOutputDto>> getAllCustemers(){
        List<CustomerAccountOutputDto> customers = cAService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerAccountOutputDto > getCustomerById(@PathVariable long id ){
        CustomerAccountOutputDto customer = cAService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/{costumerFirstname}")
    public ResponseEntity<CustomerAccountOutputDto.CustomerNameOutputDto> getCustomerByName(@PathVariable String costumerFirstname){
        CustomerAccountOutputDto.CustomerNameOutputDto customer = cAService.getCustomerByLastName(costumerFirstname);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/find/billingaddress/{id}")
    public ResponseEntity<CustomerAccountOutputDto.CustomerFinanceOutputDto>getBillingAddressById(@PathVariable long id){
        CustomerAccountOutputDto.CustomerFinanceOutputDto customer = cAService.getBillingAddressById(id);
        return ResponseEntity.ok(customer);
    }
    @GetMapping("/find/car/{owner_id}")
    public ResponseEntity<Collection<CarOutputDto>>getCarByCustomerId(@PathVariable long owner_id){
       Collection<CarOutputDto> car = carOwnerService.getCarByCustomerId(owner_id);
        return ResponseEntity.ok(car);
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
