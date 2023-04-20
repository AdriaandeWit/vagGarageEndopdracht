package Controllers;

import Service.CustumerAccountService;
import dto.input.CostumerAcountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping
@RestController

public class CustomerAccountController {



    private final CustumerAccountService cAService;

    public CustomerAccountController(CustumerAccountService cAService) {
        this.cAService = cAService;
    }

    @PostMapping()
    public ResponseEntity<Object> createCustomer(@RequestBody CostumerAcountDto cADto){
        Long id = cAService.createCostumer(cADto);
        cADto.id = id;


        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/"+ id).toUriString());

        return ResponseEntity.created(uri).body(cADto);
    }


}
