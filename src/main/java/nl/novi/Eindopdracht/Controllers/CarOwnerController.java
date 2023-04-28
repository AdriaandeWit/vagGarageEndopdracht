package nl.novi.Eindopdracht.Controllers;

import nl.novi.Eindopdracht.Models.Data.CarOwnerKey;
import nl.novi.Eindopdracht.Service.CarOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/carsowners")
public class CarOwnerController {

    private final CarOwnerService carOwnerService;

    public CarOwnerController(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }
    @PutMapping("/{carId}/{ownerId")
    public ResponseEntity<CarOwnerKey> addAccountToCar(@PathVariable("carId") Long carId,@PathVariable("ownerId") Long ownerId){
        CarOwnerKey key = carOwnerService.addAccountToCar(carId,ownerId);
        return ResponseEntity.created(null).body(key);
    }







}
