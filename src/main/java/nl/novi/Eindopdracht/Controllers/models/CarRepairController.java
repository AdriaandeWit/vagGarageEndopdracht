package nl.novi.Eindopdracht.Controllers.models;

import lombok.AllArgsConstructor;
import nl.novi.Eindopdracht.Service.ModelService.CarReparationService;
import nl.novi.Eindopdracht.dto.input.CarRepairDto;
import nl.novi.Eindopdracht.dto.output.CarRepairOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor

@RequestMapping("carRepair")
@RestController
public class CarRepairController {

private final CarReparationService reparationService;

  @PostMapping
    public ResponseEntity<Object> createCarReport(@RequestBody CarRepairDto carRepairDto){
    Long id = reparationService.createCarReport(carRepairDto);
    carRepairDto.id =id;

    URI uri = URI.create(ServletUriComponentsBuilder.
            fromCurrentRequest().path("/"+ id).toUriString());

    return ResponseEntity.created(uri).body(carRepairDto);
  }

  @GetMapping("/find/all")
  public ResponseEntity<List<CarRepairOutputDto>> getAllRapairs(){
    List<CarRepairOutputDto> carRepairOutputDtos = reparationService.getAllRapairs();
    return ResponseEntity.ok(carRepairOutputDtos);
  }
  @GetMapping("/find/{id}")
  public ResponseEntity<CarRepairOutputDto> getRepairById(@PathVariable Long id){
    CarRepairOutputDto dto= reparationService.getRepairByID(id);
  return ResponseEntity.ok(dto);
  }

  @PutMapping("/update/car-problem/{id}")
  public ResponseEntity<CarRepairDto>updateCarProblem(@PathVariable long id,@RequestBody String carProblem){
    CarRepairDto dto = reparationService.updateCarProblem(id,carProblem);
    return ResponseEntity.ok(dto);
  }
  @PutMapping("/update/repair-date/{id}")
  public ResponseEntity<CarRepairDto>updateRepairDate(@PathVariable long id,@RequestBody LocalDate repairDate){
    CarRepairDto dto = reparationService.updateRepairDate(id,repairDate);
    return  ResponseEntity.ok(dto);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteRepairById(@PathVariable long id){
    reparationService.deleteRepairById(id);
    return ResponseEntity.noContent().build();
  }
  @DeleteMapping("/delete/all")
  public ResponseEntity<String> deleteAllRepairs(){
    reparationService.deleteAllRepairs();
    return ResponseEntity.noContent().build();
  }


}
