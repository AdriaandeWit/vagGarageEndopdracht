package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.CarParts.Brakes;
import nl.novi.Eindopdracht.Repository.BrakeRepository;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.BrakesDto;
import nl.novi.Eindopdracht.dto.output.BrakesOutputDto;
import nl.novi.Eindopdracht.mappers.BrakeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrakeService {

    private final BrakeRepository brakeRepos;

    private final CarRepository  carRepos;

    private final BrakeMapper brakeMapper;


    public BrakeService(BrakeRepository brakeRepos, CarRepository carRepos, BrakeMapper brakeMapper) {
        this.brakeRepos = brakeRepos;
        this.carRepos = carRepos;
        this.brakeMapper = brakeMapper;
    }


    public Long createBrake(BrakesDto brakesDto ) {
        Brakes brakes = BrakeMapper.MAPPER.mapToBrake(brakesDto);
        Brakes savedBrake = brakeRepos.save(brakes);

        BrakesOutputDto savedBrakeDto = brakeMapper.MAPPER.mapToBrakeDto(savedBrake);

        return savedBrakeDto.id;
    }

    public List<BrakesOutputDto> getAllBrakes() {
        List<Brakes> brakes = brakeRepos.findAll();
        return brakes.stream().map(brakeMapper::mapToBrakeDto).collect(Collectors.toList());


    }
    public BrakesOutputDto getBrakeById(long id) {
        Brakes brake = brakeRepos.findById(id).orElseThrow(
                ()-> new RecordNotFoundException("brake","id",id )
        );
        return BrakeMapper.MAPPER.mapToBrakeDto(brake);
    }
    public List<BrakesOutputDto> getAllBrakesByCarId(long carId) {


    }

    public Object updateAmountOfParts(Long id, Integer amountOfParts) {
        var optionalBrake = brakeRepos.findById(id);
        if(optionalBrake.isPresent()){
            var brake = optionalBrake.get();
            brake.setAmountOfParts(amountOfParts);
            brakeRepos.save(brake);
        }else {
            throw new RecordNotFoundException("amountOfParts","id",id);
        }
        return null;
    }

    public Object updatePrice(Long id, Double price){
        var optionalBrake = brakeRepos.findById(id);
        if(optionalBrake.isPresent()){
        var brake = optionalBrake.get();
        brake.setPrice(price);
        brakeRepos.save(brake);
    }else {
        throw new RecordNotFoundException("price","id",id);
    }
        return null;
    }


    public Object updatePartNumber(Long id, String partNumber) {
        var optionalBrake = brakeRepos.findById(id);
        if(optionalBrake.isPresent()){
            var brake = optionalBrake.get();
            brake.setPartNumber(partNumber);
            brakeRepos.save(brake);
        }else {
            throw new RecordNotFoundException("partNumber","id",id);
        }
        return null;
    }
        
    }

    public void addBrakeToCar(Long id, Long carId) {
    }

    public String deleteBrakeById(Long id) {
        Brakes existingBrake = brakeRepos.findById(id).orElseThrow(
                () -> new RecordNotFoundException("brake", "id",id)
        );

        brakeRepos.deleteById(id);
        return "you delete the brake";


    }

    public String deleteAllBrakes() {
    Long count = brakeRepos.count();
    brakeRepos.deleteAll();
    return "You deleted"+ count+ "brakes";
    }


}
