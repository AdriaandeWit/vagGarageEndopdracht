package nl.novi.Eindopdracht.Controllers;


import lombok.AllArgsConstructor;
import nl.novi.Eindopdracht.Service.CarService;
import nl.novi.Eindopdracht.Service.CustomerAccountService;
import nl.novi.Eindopdracht.dto.input.CarDto;
import nl.novi.Eindopdracht.dto.output.CarOutputDto;
import nl.novi.Eindopdracht.dto.output.CustomerAccountOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RequestMapping("car")
@RestController
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    private final CustomerAccountService cAService;





    @PostMapping
    public ResponseEntity<Object> createCar(@RequestBody CarDto carDto){
        Long id = carService.createCar(carDto);
        carDto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/"+ id).toUriString());

        return ResponseEntity.created(uri).body(carDto);
    }

    @GetMapping("find/all")
    public ResponseEntity<List<CarOutputDto>> getAllCars(){
        List<CarOutputDto> carOutputDto = carService.getAllCars();
        return ResponseEntity.ok(carOutputDto);
    }

    @GetMapping("/find")
    public ResponseEntity<CarOutputDto > getCarById(@RequestParam String licensePlate ){
        CarOutputDto carOutputDto = carService.getCarByCarId(licensePlate);
        return ResponseEntity.ok(carOutputDto);
    }

    @GetMapping("/find")
    public ResponseEntity<CustomerAccountOutputDto> getAccountByLicensePlate(@RequestParam String licensePlate){
        CustomerAccountOutputDto account = cAService.getAccountByLicensePlate(licensePlate);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/update/mileage")
    public ResponseEntity<CarDto> updateCarMileage(@RequestParam  String licensePlate ,@RequestParam Integer mileage   ){

        CarDto carDto =  carService.updateCarMileage(licensePlate ,mileage);
        return ResponseEntity.ok(carDto);
    }

    @PutMapping("/update/engineType")
    public ResponseEntity<CarDto> updateEngineType(@RequestParam String licensePlate, @RequestParam String engineType){
        CarDto carDto = carService.updateEngineType(licensePlate,engineType);
        return ResponseEntity.ok(carDto);

    }
    @PutMapping("/car/owner")
    public ResponseEntity<Object>addAccountToCar(@RequestParam String licensePlate, @RequestParam String customerName){
        carService.addAccountToCar(licensePlate,customerName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCarById(@RequestParam String licensePlate){
        carService.deleteCarByLicensePlate(licensePlate);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllCars(){
        carService.deleteAllCars();
        return ResponseEntity.noContent().build();

    }
}
