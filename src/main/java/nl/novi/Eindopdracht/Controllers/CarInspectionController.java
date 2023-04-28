package nl.novi.Eindopdracht.Controllers;

import nl.novi.Eindopdracht.Service.CarInspectionService;
import nl.novi.Eindopdracht.dto.input.CarInspectionDto;
import nl.novi.Eindopdracht.dto.output.CarInspectionOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RequestMapping("inspection")
@RestController
public class CarInspectionController {

    private final CarInspectionService carInspectionService;

    public CarInspectionController(CarInspectionService carInspectionService) {
        this.carInspectionService = carInspectionService;
    }

    @PostMapping
    public ResponseEntity<Object> createInspection(@ResponseBody CarInspectionDto carInspectionDto){
    Long id = carInspectionService.createInspection(carInspectionDto);
    carInspectionDto.id = id;

    URI uri = URI.create(ServletUriComponentsBuilder.
            fromCurrentRequest().path("/"+ id).toUriString());

    return ResponseEntity.created(uri).body(carInspectionDto);
}
    @GetMapping("/find/{id}")
    public ResponseEntity<CarInspectionOutputDto> getInspectionById(@PathVariable long id){
        CarInspectionOutputDto carInspectionOutputDto = carInspectionService.getInspectionByID(id);
        return ResponseEntity.ok(carInspectionOutputDto);
    }
    @PutMapping("/update/milleage/{id}")
    public ResponseEntity<Object> updateMileAgeleAge(@PathVariable Long id ,@RequestParam int milleAge{
        carInspectionService.updateMileAge(id,milleAge);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/inspectiondate/{id}")
    public ResponseEntity<Object> updateInspectionDate(@PathVariable Long id, @RequestParam LocalDate inspectionDate){
       CarInspectionDto inspectionDto = carInspectionService.updateInspectionDate(id,inspectionDate);
        return ResponseEntity.ok(inspectionDto);
    }

    @PutMapping("/update/isfine/statuscar/{id}")
    public ResponseEntity<String>updateCarIsFine(@PathVariable Long id, @RequestParam String carIsFine){
        carInspectionService.updateCarIsFine(id,carIsFine);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/isincorrect/statuscar/{id}")
    public ResponseEntity<String> updateHasProblem(@PathVariable Long id, @RequestParam String hasProblem){
        carInspectionService.updateHasProblem(id,hasProblem);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/update/cariscorrect")
    public ResponseEntity<Object> updateStatusCar(@PathVariable Long id,@RequestParam boolean carIsCorrect){
        carInspectionService.updateStatusCar(id,carIsCorrect);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete/inspection/{id}")
    public ResponseEntity<String>delteInspectionById(@PathVariable Long id ){
        carInspectionService.delteInspectionById();
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/inspections")
    public ResponseEntity<String> deleteAllInspections(){
        carInspectionService.deleteAllInspections();
        return ResponseEntity.noContent().build();

    }

}
