package Controllers;


import Service.CarOwnerService;
import Service.CarService;
import dto.input.CarDto;
import dto.output.CarOutputDto;
import dto.output.CustomerAccountOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
@RequestMapping("car")
@RestController

public class CarController {

    private final CarService carService;

    private final CarOwnerService carOwnerService;

    public CarController(CarService carService, CarOwnerService carOwnerService) {
        this.carService = carService;
        this.carOwnerService = carOwnerService;
    }


    @PostMapping
    public ResponseEntity<Object> createCar(@RequestBody CarDto carDto){
        Long id = carService.createCar(carDto);
        carDto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/"+ id).toUriString());

        return ResponseEntity.created(uri).body(carDto);
    }

    @GetMapping
    public ResponseEntity<List<CarOutputDto>> getAllCars(){
        List<CarOutputDto> carOutputDto = carService.getAllCars();
        return ResponseEntity.ok(carOutputDto);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CarOutputDto > getCarById(@PathVariable long id ){
        CarOutputDto carOutputDto = carService.getCarById(id);
        return ResponseEntity.ok(carOutputDto);
    }

    @GetMapping("/find/{carId}")
    public ResponseEntity<Collection<CustomerAccountOutputDto>> getAccountByCarId(@PathVariable Long carId){
        Collection<CustomerAccountOutputDto> account = carOwnerService.getAccountByCarId(carId);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/update/mileage/{id}")
    public ResponseEntity<CarDto> updateCarMileage(@PathVariable long id,@RequestParam Integer mileage   ){

        CarDto carDto =  carService.updateCarMileage(id, mileage);
        return ResponseEntity.ok(carDto);
    }

    @PutMapping("/update/mileage/{id}")
    public ResponseEntity<CarDto> updateEngineType(@PathVariable long id, @RequestParam String engineType){
        CarDto carDto = carService.updateEngineType(id,engineType);
        return ResponseEntity.ok(carDto);

    }
    @PutMapping("/car/owner/{id}/{ownerId}")
    public ResponseEntity<Object>addAccountToCar(@PathVariable long id, @PathVariable("owenerId") long ownerId ){
        carOwnerService.addAccountToCar(id,ownerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable long id){
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllCars(){
        carService.deleteAllCars();
        return ResponseEntity.noContent().build();

    }
}
