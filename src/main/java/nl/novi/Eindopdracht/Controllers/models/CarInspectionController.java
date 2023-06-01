package nl.novi.Eindopdracht.Controllers.models;

import nl.novi.Eindopdracht.Service.ModelService.CarInspectionService;
import nl.novi.Eindopdracht.dto.input.CarInspectionDto;
import nl.novi.Eindopdracht.dto.output.CarInspectionOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("inspection")
@RestController
public class CarInspectionController {

    private final CarInspectionService carInspectionService;

    public CarInspectionController(CarInspectionService carInspectionService) {
        this.carInspectionService = carInspectionService;
    }

    @PostMapping
    public ResponseEntity<Object> createInspection(CarInspectionDto carInspectionDto) {
        Long id = carInspectionService.createInspection(carInspectionDto);
        carInspectionDto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(carInspectionDto);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CarInspectionOutputDto> getInspectionById(@PathVariable long id) {
        CarInspectionOutputDto carInspectionOutputDto = carInspectionService.getInspectionByID(id);
        return ResponseEntity.ok(carInspectionOutputDto);
    }

    @GetMapping("/find/all/{id}")
    public ResponseEntity<List<CarInspectionOutputDto>> getAllInspectionsById(@PathVariable long id) {
        List<CarInspectionOutputDto> carInspectionOutputDtos = carInspectionService.getAllInspections();
        return ResponseEntity.ok(carInspectionOutputDtos);
    }

    @PutMapping("/update/mileage/{id}")
    public ResponseEntity<Object> updateMileAge(@PathVariable Long id, @RequestParam int milleAge) {
        carInspectionService.updateMileAge(id, milleAge);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/inspectionDate/{id}")
    public ResponseEntity<Object> updateInspectionDate(@PathVariable Long id, @RequestParam LocalDate inspectionDate) {
        CarInspectionDto inspectionDto = carInspectionService.updateInspectionDate(id, inspectionDate);
        return ResponseEntity.ok(inspectionDto);
    }

    @PutMapping("/update/isFine/statusCar/{id}")
    public ResponseEntity<String> updateCarIsFine(@PathVariable Long id, @RequestParam String carIsFine) {
        carInspectionService.updateCarIsFine(id, carIsFine);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/isIncorrect/statusCar/{id}")
    public ResponseEntity<String> updateHasProblem(@PathVariable Long id, @RequestParam String hasProblem) {
        carInspectionService.updateHasProblem(id, hasProblem);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/carIsCorrect/{id}")
    public ResponseEntity<Object> updateStatusCar(@PathVariable Long id, @RequestParam boolean carIsCorrect) {
        carInspectionService.updateCarStatus(id, carIsCorrect);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/delete/inspection/{id}")
    public ResponseEntity<String> deleteInspectionById(@PathVariable Long id) {
        carInspectionService.deleteInspectionById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/inspections")
    public ResponseEntity<String> deleteAllInspections() {
        carInspectionService.deleteAllInspections();
        return ResponseEntity.noContent().build();

    }

}
