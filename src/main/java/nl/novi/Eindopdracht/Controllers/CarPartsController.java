package nl.novi.Eindopdracht.Controllers;

import nl.novi.Eindopdracht.Service.CarPartsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/carpatrs")
@RestController
public class CarPartsController {

    private final CarPartsService carPartsService;

    private final


    public CarPartsController(CarPartsService carPartsService) {
        this.carPartsService = carPartsService;
    }




}
