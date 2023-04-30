package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Exceptions.InspectionNotFoundException;
import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.CarInspection;
import nl.novi.Eindopdracht.Repository.CarInspectionRepository;
import nl.novi.Eindopdracht.dto.input.CarInspectionDto;
import nl.novi.Eindopdracht.dto.output.CarInspectionOutputDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarInspectionService {

    private final CarInspectionRepository carInspectionRepos;

    public CarInspectionService(CarInspectionRepository carInspectionRepos) {
        this.carInspectionRepos = carInspectionRepos;
    }


    public Long createInspection(CarInspectionDto carInspectionDto) {
        CarInspection inspection = DtoToCarInspection(carInspectionDto);

        carInspectionRepos.save(inspection);
        return inspection.getId();
    }
    public CarInspectionOutputDto getInspectionByID(long id) {
        Optional<CarInspection> inspection = carInspectionRepos.findById(id);
        if (inspection.isEmpty()) {
            throw  new RecordNotFoundException("Cannot find inspcetion please enter a anther id ");
        }
        else {
            CarInspection i = inspection.get();
            return inspectionToDto(i);
        }
    }
    public List<CarInspectionOutputDto> getAllInspectionsById(long id){
    List<CarInspectionOutputDto> collectionOffId = new ArrayList<>();
    List<CarInspection> list= carInspectionRepos.findAllById(Collections.singleton(id));
        if(list.isEmpty()){
            throw new RecordNotFoundException("there are no records found on "+ id +"please check a anther id");
         }else {
            for (CarInspection i: list) {
            collectionOffId.add(inspectionToDto(i));
        }
        return collectionOffId;
    }
    }







    public CarInspectionOutputDto inspectionToDto(CarInspection carInspection){
        CarInspectionOutputDto dto = new CarInspectionOutputDto();

        dto.id= carInspection.getId();
        dto.milleAge = carInspection.getMileAge();
        dto.licensePlate = carInspection.getLicensePlate();
        dto.costumerNumber=carInspection.getCostumerNumber();
        dto.inspectionDate=carInspection.getInspectionDate();
        dto.carIsCorrect=carInspection.isCarIsCorrect();
        dto.carIsFine=carInspection.getCarIsFine();
        dto.carIsincorrect=carInspection.isCarIsIncorrect();
        dto.hasProblem=carInspection.getHasProblem();

        return dto;

    }

    public CarInspection DtoToCarInspection (CarInspectionDto inspectionDto){
        CarInspection inspection = new CarInspection();

        inspection.setMileAge(inspectionDto.milleAge);
        inspection.setLicensePlate(inspectionDto.licensePlate);
        inspection.setCostumerNumber(inspectionDto.costumerNumber);
        inspection.setInspectionDate(inspectionDto.inspectionDate);
        inspection.setCarIsIncorrect(inspectionDto.carIsCorrect);
        inspection.setCarIsFine(inspectionDto.carIsFine);
        inspection.setCarIsIncorrect(inspectionDto.carIsIncorrect);
        inspection.setHasProblem(inspectionDto.hasProblem);

        return  inspection;

    }

    public CarInspectionDto updateMileAge(Long id, int milleAge) {
        var optionalcarInspection = carInspectionRepos.findById(id);
        if(optionalcarInspection.isPresent()){
            var carInspection = optionalcarInspection.get();
            carInspection.setMileAge(milleAge);
            carInspectionRepos.save(carInspection);
        }else {
            throw new RecordNotFoundException("Can find "+ id + " please enter a anther id");
        }
        return null;
    }



    public CarInspectionDto updateInspectionDate(Long id, LocalDate inspectionDate) {
        var optionalCarInspection =carInspectionRepos.findById(id);
        if (optionalCarInspection.isPresent()){
            var carInspection = optionalCarInspection.get();
            carInspection.setInspectionDate(inspectionDate);
            carInspectionRepos.save(carInspection);
        }else {
            throw new RecordNotFoundException("cannot find "+ id + "please enter a anther id" );

        }
        return null;
    }


    public CarInspectionDto updateCarIsFine(Long id, String carIsFine) {
    var optionalCarInspection = carInspectionRepos.findById(id);
    if(optionalCarInspection.isPresent()){
        var carInspection = optionalCarInspection.get();
        carInspection.setCarIsFine(carIsFine);
        carInspectionRepos.save(carInspection);
    }else {
        throw new RecordNotFoundException("cannot find "+ id + "please enter a anther id");
    }
    return null;
    }

    public CarInspectionDto updateHasProblem(Long id, String hasProblem) {
        var optionalCarInspection = carInspectionRepos.findById(id);
        if(optionalCarInspection.isPresent()){
            var carInspection = optionalCarInspection.get();
            carInspection.setCarIsFine(hasProblem);
            carInspectionRepos.save(carInspection);
        }else {
            throw new RecordNotFoundException("cannot find "+ id + "please enter a anther id");
        }
        return null;

    }

    public boolean updateStatusCar(Long id, boolean carIsCorrect,boolean carIsIncorrect) {
            var optionalCarInspection = carInspectionRepos.findById(id);
            if (optionalCarInspection.isPresent()) {
                var carInspection = optionalCarInspection.get();
                if (carIsCorrect) {
                    carInspection.setCarIsIncorrect(false);
                    carInspection.setCarIsCorrect(true);
                } else {
                    carInspection.setCarIsCorrect(false);
                    carInspection.setCarIsIncorrect(true);
                }
                carInspectionRepos.save(carInspection);
                return true;
            } else {
                return false;
            }
    }

    public String deleteInspectionById(Long id) {
        if (!carInspectionRepos.existsById(id)){
            throw new InspectionNotFoundException("Inspection with id"+ id+ "is not found");
        }else{
            Long count = carInspectionRepos.count();
            carInspectionRepos.deleteById(id);
            return " you deleted" + count + "in the " + id;
        }

    }

    public String deleteAllInspections() {
        Long count = carInspectionRepos.count();
        carInspectionRepos.deleteAll();
        return "We delted"+ count + "inspections";
    }


}


