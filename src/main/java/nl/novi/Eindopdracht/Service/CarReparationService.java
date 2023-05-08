package nl.novi.Eindopdracht.Service;

import lombok.AllArgsConstructor;
import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;

import nl.novi.Eindopdracht.Models.Data.CarRepair;
import nl.novi.Eindopdracht.Repository.CarReparationRepository;

import nl.novi.Eindopdracht.dto.input.CarRepairDto;

import nl.novi.Eindopdracht.dto.output.CarRepairOutputDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Service
public class CarReparationService {

    private final CarReparationRepository repairRepos;

    public CarReparationService(CarReparationRepository repairRepos) {
        this.repairRepos = repairRepos;
    }

    // TODO: 07/05/2023 //overleg met Mark of het mogenlijk is om in de create rekening te houden met de totalCost.
    public Long createCarReport(CarRepairDto carRepairDto) {
        CarRepair carRepair = DtoToRepair(carRepairDto);

        repairRepos.save(carRepair);
        return carRepair.getId();
    }
    public CarRepairOutputDto getRepairByID(Long id) {
        Optional<CarRepair> optionalR = repairRepos.findById(id);
        if (optionalR.isEmpty()){
            throw new RecordNotFoundException("Rapair","id",id);
        }else{
            CarRepair carR = optionalR.get();
            return RepairToDto(carR);

        }
    }
    public List<CarRepairOutputDto> getAllRapairs() {
        List<CarRepairOutputDto> collection = new ArrayList<>();
        List<CarRepair> list = repairRepos.findAll();
        for (CarRepair carRepair: list){
            collection.add(RepairToDto(carRepair));
        }
        return collection;
    }

    public CarRepairDto updateCarProblem(long id, String carProblem) {
        Optional<CarRepair> optionalRepair = repairRepos.findById(id);
        if (optionalRepair.isPresent()){
            CarRepair carR = optionalRepair.get();
            carR.setCarProblem(carProblem);
            repairRepos.save(carR);

        }else{
            throw new RecordNotFoundException("CarProblem","id",id);
        }
        return null;
    }

    public CarRepairDto updateRepairDate(long id, LocalDate repairDate) {
        Optional<CarRepair> optionalRepair = repairRepos.findById(id);
        if ((optionalRepair.isPresent())) {
            CarRepair carR = optionalRepair.get();
            carR.setRepairDate(repairDate);
            repairRepos.save(carR);
        } else {
            throw new RecordNotFoundException("repaireDate", "id", id);
        }
        return null;
    }


    public String deleteRepairById(long id) {
        if (repairRepos.existsById(id)){
            long count = repairRepos.count();
            repairRepos.deleteById(id);
            return"You delete "+ count +" in the id "+ id;
        }else{
            throw new RecordNotFoundException("repair","id",id);
        }
    }

    public String deleteAllRepairs() {
        long count = repairRepos.count();
        repairRepos.deleteAll();
        return "You deleted "+ count + "cars";

    }

    public Double createTotalCost(double partCost,double laborCost){
        Double totalCost = partCost + laborCost;
        return totalCost;


    }


    public CarRepairOutputDto RepairToDto(CarRepair repair) {
         CarRepairOutputDto dto = new CarRepairOutputDto();

        dto.id = repair.getId();
        dto.Car = repair.getCar();
        dto.carProblem = repair.getCarProblem();
        dto.repairDate = repair.getRepairDate();
        dto.partCost = repair.getPartCost();
        dto.laborCost = repair.getLaborCost();
        dto.totalCost = repair.getTotalCost();


        return dto;
    }

    public CarRepair DtoToRepair(CarRepairDto repairDto){
        CarRepair carR = new CarRepair();

        carR.setCar(repairDto.Car);
        carR.setCarProblem(repairDto.carProblem);
        carR.setRepairDate(repairDto.repairDate);
        carR.setPartCost(repairDto.partCost);
        carR.setLaborCost(repairDto.laborCost);
        carR.setTotalCost(repairDto.totalCost);

        return carR;
    }


}
