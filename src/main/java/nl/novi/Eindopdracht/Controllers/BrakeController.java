package nl.novi.Eindopdracht.Controllers;

import nl.novi.Eindopdracht.Service.BrakeService;
import nl.novi.Eindopdracht.Service.CarService;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.BrakesDto;
import nl.novi.Eindopdracht.dto.output.CarPartsDto.BrakesOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/car/parts/brakes")
@RestController
public class BrakeController {

    private final BrakeService brakeService;

    private final CarService carService;


    public BrakeController(BrakeService brakeService,CarService carService) {
        this.brakeService = brakeService;
        this.carService = carService;
    }



    @PostMapping("create")
    public ResponseEntity<Object>createBrake(@RequestBody BrakesDto brakesDto){
        Long id =brakeService.createBrake(brakesDto);
        brakesDto.id= id;

        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/"+ id).toUriString());
        return ResponseEntity.created(uri).body(brakesDto);

    }

    @GetMapping("/find/all")
    public ResponseEntity<List<BrakesOutputDto>>getAllBrakes(){
        List<BrakesOutputDto> brakesOutputDtoList = brakeService.getAllBrakes();
        return ResponseEntity.ok(brakesOutputDtoList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BrakesOutputDto>getBrakeById(@PathVariable long id){
        BrakesOutputDto brakesOutputDto = brakeService.getBrakeById(id);
        return ResponseEntity.ok(brakesOutputDto);
    }
/*
    @GetMapping("/find/all/brackes/{CarId}")
    public ResponseEntity<List<BrakesOutputDto>>getAllbrakesByCarId(@PathVariable("CarID") long carId){
        List<BrakesOutputDto> brakesOutputDtoList = brakeService.getAllBrakesByCarId(carId);
        return ResponseEntity.ok(brakesOutputDtoList);

    }
*/
    @PutMapping("/update/amountOfParts/{id}")
    public ResponseEntity<Object>updateAmountOfParts(@PathVariable Long id,@RequestParam Integer amountOfParts){
         brakeService.updateAmountOfParts(id,amountOfParts);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/price/{id}/")
    public ResponseEntity<Object>updatePrice(@PathVariable Long id,@RequestParam Double price){
        brakeService.updatePrice(id,price);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/partNumber/{id}")
    public ResponseEntity<Object>updatePartNumber(@PathVariable Long id,@RequestParam String partNumber){
        brakeService.updatePartNumber(id,partNumber);
        return ResponseEntity.ok().build();
    }

  //  @PutMapping("/add/brake/{carId}/car/{carId}")
  //  public ResponseEntity<Object>addBrakeToCar(@PathVariable Long carId,@PathVariable ("carId") Long carId){
  //      brakeService.addBrakeToCar(carId,carId);
  //      return  ResponseEntity.ok().build();
  //  }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBrakeById(Long id){
        brakeService.deleteBrakeById(id);
        return  ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/All")
    public ResponseEntity<String>deleteAllBrakes(){
        brakeService.deleteAllBrakes();
        return ResponseEntity.noContent().build();
    }



}
