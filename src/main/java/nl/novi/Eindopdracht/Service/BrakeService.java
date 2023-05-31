package nl.novi.Eindopdracht.Service;

import lombok.AllArgsConstructor;
import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.CarParts.Brakes;
import nl.novi.Eindopdracht.Repository.BrakeRepository;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.BrakesDto;
import nl.novi.Eindopdracht.dto.output.CarPartsDto.BrakesOutputDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class BrakeService {

    private final BrakeRepository brakeRepos;

    private final CarRepository  carRepos;



    public Long createBrake(BrakesDto brakesDto ) {
        Brakes brakes = mapToBrake(brakesDto);
        Brakes savedBrake = brakeRepos.save(brakes);

        BrakesOutputDto savedBrakeDto = mapToBrakeDto(savedBrake);

        return savedBrakeDto.id;
    }

    public List<BrakesOutputDto> getAllBrakes() {
        List<BrakesOutputDto> collectionBrakes =new ArrayList<>();
        List<Brakes> brakesList = brakeRepos.findAll();
        for (Brakes brake: brakesList ){
            collectionBrakes.add(mapToBrakeDto(brake));
        }
        return  collectionBrakes;


    }
    public BrakesOutputDto getBrakeById(long id) {
        Brakes brake = brakeRepos.findById(id).orElseThrow(
                ()-> new RecordNotFoundException("brake","id",id )
        );
        return mapToBrakeDto(brake);
    }
    /* public List<BrakesOutputDto> getAllBrakesByCarId(long carId) {

return
    }
*/
    public Object updateAmountOfParts(Long id, Integer amountOfParts) {
        Optional<Brakes> optionalBrake = brakeRepos.findById(id);
        if(optionalBrake.isEmpty()){
            throw new RecordNotFoundException("amountOfParts","id",id);

        }else {
            Brakes brake = optionalBrake.get();
            brake.setAmountOfParts(amountOfParts);
            brakeRepos.save(brake);

        }
        return null;
    }

    public Object updatePrice(Long id, Double price){
        Optional<Brakes> optionalBrake = brakeRepos.findById(id);
        if(optionalBrake.isPresent()){
        Brakes brake = optionalBrake.get();
        brake.setPrice(price);
        brakeRepos.save(brake);
    }else {
        throw new RecordNotFoundException("price","id",id);
    }
        return null;
    }


    public Object updatePartNumber(Long id, String partNumber) {
        Optional<Brakes> optionalBrake = brakeRepos.findById(id);
        if(optionalBrake.isPresent()){
            Brakes brake = optionalBrake.get();
            brake.setPartNumber(partNumber);
            brakeRepos.save(brake);
        }else {
            throw new RecordNotFoundException("partNumber","id",id);
        }
        return null;
    }
        


 //   public void addBrakeToCar(Long carId, Long carId) {

//}

    public String deleteBrakeById(Long id) {
        brakeRepos.findById(id).orElseThrow(
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
    public BrakesOutputDto mapToBrakeDto(Brakes brakes) {
        if ( brakes == null ) {
            return null;
        }

        BrakesOutputDto brakesOutputDto = new BrakesOutputDto();

        brakesOutputDto.id = brakes.getId();
        brakesOutputDto.partName = brakes.getPartName();
        brakesOutputDto.partNumber = brakes.getPartNumber();
        brakesOutputDto.price = brakes.getPrice();
        brakesOutputDto.amountOfParts = brakes.getAmountOfParts();
        brakesOutputDto.centerDiameter = brakes.getCenterDiameter();
        brakesOutputDto.minThickness = brakes.getMinThickness();
        brakesOutputDto.surface = brakes.getSurface();
        brakesOutputDto.discThickness = brakes.getDiscThickness();
        brakesOutputDto.boreTypeNumberOfHoles = brakes.getBoreTypeNumberOfHoles();
        brakesOutputDto.wheelStudDiameter = brakes.getWheelStudDiameter();
        brakesOutputDto.withoutWheelMountingBolts = brakes.getWithoutWheelMountingBolts();
        brakesOutputDto.withoutWheelHub = brakes.getWithoutWheelHub();

        return brakesOutputDto;
    }

    public Brakes mapToBrake(BrakesDto brakesDto) {
        if ( brakesDto == null ) {
            return null;
        }

        Brakes brakes = new Brakes();

        brakes.setId( brakesDto.id );
        brakes.setPartName( brakesDto.partName );
        brakes.setPartNumber( brakesDto.partNumber );
        brakes.setPrice( brakesDto.price );
        brakes.setAmountOfParts( brakesDto.amountOfParts );
        brakes.setOuterDiameter( brakesDto.outerDiameter );
        brakes.setCenterDiameter( brakesDto.centerDiameter );
        brakes.setHeight( brakesDto.height );
        brakes.setMinThickness( brakesDto.minThickness );
        brakes.setSurface( brakesDto.surface );
        brakes.setDiscThickness( brakesDto.discThickness );
        brakes.setBoreTypeNumberOfHoles( brakesDto.boreTypeNumberOfHoles );
        brakes.setWheelStudDiameter( brakesDto.wheelStudDiameter );
        brakes.setWithoutWheelMountingBolts( brakesDto.withoutWheelMountingBolts );
        brakes.setWithoutWheelHub( brakesDto.withoutWheelHub );

        return brakes;
    }


}
