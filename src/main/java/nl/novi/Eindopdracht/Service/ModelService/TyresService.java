package nl.novi.Eindopdracht.Service.ModelService;

import lombok.AllArgsConstructor;
import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.CarParts.Tyres;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.Repository.TyreRepository;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.TyresDto;
import nl.novi.Eindopdracht.dto.output.CarPartsDto.TyresOutputDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TyresService {

    private final TyreRepository TyreRepos;

    private final CarRepository  carRepos;



    public Long createTyre(TyresDto tyresDto) {
        Tyres tyre = mapToTyre(tyresDto);
        Tyres savedTyre = TyreRepos.save(tyre);

        TyresOutputDto savedTyresDto = mapToTyreDto(savedTyre);

        return savedTyresDto.id;
    }

    public List<TyresOutputDto> getAllTyres() {
        List<TyresOutputDto> collectionTyres =new ArrayList<>();
        List<Tyres> tyresList = TyreRepos.findAll();
        for (Tyres tyres: tyresList){
            collectionTyres.add(mapToTyreDto(tyres));
        }
        return collectionTyres ;


    }
    public TyresOutputDto getTyreById(long id) {
        Tyres tyres= TyreRepos.findById(id).orElseThrow(
                ()-> new RecordNotFoundException("Tyres","id",id )
        );
        return mapToTyreDto(tyres);
    }
    /* public List<BrakesOutputDto> getAllBrakesByCarId(long carId) {

return
    }
*/
    public Object updateAmountOfParts(Long id, Integer amountOfParts) {
        Optional<Tyres> optionalTyres = TyreRepos.findById(id);
        if(optionalTyres.isPresent()){
            Tyres tyres = optionalTyres.get();
            tyres.setAmountOfParts(amountOfParts);
            TyreRepos.save(tyres);
        }else {
            throw new RecordNotFoundException("amountOfParts","id",id);
        }
        return null;
    }

    public Object updatePrice(Long id, Double price){
        Optional<Tyres> optionalTyres = TyreRepos.findById(id);
        if(optionalTyres.isPresent()){
        Tyres tyres = optionalTyres.get();
        tyres.setPrice(price);
        TyreRepos.save(tyres);
    }else {
        throw new RecordNotFoundException("price","id",id);
    }
        return null;
    }


    public Object updatePartNumber(Long id, String partNumber) {
        Optional<Tyres> optionalTyres = TyreRepos.findById(id);
        if(optionalTyres.isPresent()){
            Tyres tyres = optionalTyres.get();
            tyres.setPartNumber(partNumber);
            TyreRepos.save(tyres);
        }else {
            throw new RecordNotFoundException("partNumber","id",id);
        }
        return null;
    }
        


 //   public void addBrakeToCar(Long carId, Long carId) {

//}

    public String deletetyreById(Long id) {
        Tyres existingTyre = TyreRepos.findById(id).orElseThrow(
                () -> new RecordNotFoundException("Tyres", "id",id)
        );

        TyreRepos.deleteById(id);
        return "you delete the brake";


    }

    public String deleteAllBrakes() {
    Long count = TyreRepos.count();
    TyreRepos.deleteAll();
    return "You deleted"+ count+ "brakes";
    }




    public TyresOutputDto mapToTyreDto(Tyres tyres) {
        if ( tyres == null ) {
            return null;
        }

        TyresOutputDto tyresOutputDto = new TyresOutputDto();

        tyresOutputDto.id = tyres.getId();
        tyresOutputDto.partName = tyres.getPartName();
        tyresOutputDto.partNumber = tyres.getPartNumber();
        tyresOutputDto.price = tyres.getPrice();
        tyresOutputDto.amountOfParts = tyres.getAmountOfParts();
        tyresOutputDto.tyresHight =
        tyresOutputDto.tyresWidth = tyres.getTyresWidth();
        tyresOutputDto.diameter = tyres.getDiameter();
        tyresOutputDto.loadIndex = tyres.getLoadIndex();
        tyresOutputDto.speedIndex = tyres.getSpeedIndex();
        tyresOutputDto.productionDate = tyres.getProductionDate();

        return tyresOutputDto;
    }

    public Tyres mapToTyre(TyresDto tyresDto) {
        if ( tyresDto == null ) {
            return null;
        }

        Tyres tyres  = new Tyres();

        tyres.setId( tyresDto.id );
        tyres.setPartName( tyresDto.partName );
        tyres.setPartNumber( tyresDto.partNumber );
        tyres.setPrice( tyresDto.price );
        tyres.setAmountOfParts( tyresDto.amountOfParts );
        tyres.setTyresHight( tyresDto.tyresHight );
        tyres.setTyresWidth( tyresDto.tyresWidth );
        tyres.setDiameter( tyresDto.diameter );
        tyres.setLoadIndex( tyresDto.loadIndex );
        tyres.setSpeedIndex( tyresDto.speedIndex);
        tyres.setProductionDate( tyresDto.productionDate );


        return tyres;
    }


}
