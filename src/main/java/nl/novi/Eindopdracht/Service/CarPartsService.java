package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Repository.CarPartsRepository;
import org.springframework.stereotype.Service;

@Service
public class CarPartsService {

    private final CarPartsRepository carPartsRepos;

    public CarPartsService(CarPartsRepository carPartsRepos) {
        this.carPartsRepos = carPartsRepos;
    }



}
