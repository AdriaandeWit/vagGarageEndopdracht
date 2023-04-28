package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Repository.CarInspectionRepository;
import org.springframework.stereotype.Service;

@Service
public class CarInspectionService {

    private final CarInspectionRepository carInspectionRepos;

    public CarInspectionService(CarInspectionRepository carInspectionRepos) {
        this.carInspectionRepos = carInspectionRepos;
    }




}
