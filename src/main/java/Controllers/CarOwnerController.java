package Controllers;

import Models.Data.CarOwnerKey;
import Service.CarOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/CarsOwners")
public class CarOwnerController {

    private final CarOwnerService carOwnerService;

    public CarOwnerController(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }
    @PutMapping("/{carid}/{ownerId")
    public ResponseEntity<CarOwnerKey> addAccountToCar(@PathVariable("carId") Long carId,@PathVariable("ownerId") Long ownerId){
        CarOwnerKey key = carOwnerService.addAccountToCar(carId,ownerId);
        return ResponseEntity.created(null).body(key);
    }







}
