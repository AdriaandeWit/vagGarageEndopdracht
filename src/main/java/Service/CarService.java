package Service;

import Models.Data.Car;
import Repository.CarRepository;
import dto.input.CarDto;
import dto.output.CarOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

public class CarService {
    @Autowired
    private final CarRepository carRepos;

    public CarService(CarRepository carRepos) {
        this.carRepos = carRepos;
    }
    public CarOutputDto carToDto(Car car) {
        CarOutputDto dto = new CarOutputDto();

        dto.id = car.getId();
        dto.brand = car.getBrand();
        dto.model = car.getModel();
        dto.yearOfBuild = car.getYearOfBuild();
        dto.color = car.getColor();
        dto.licensePlate =car.getLicensePlate();
        dto.mileage = car.getMileage();
        dto.engineType = car.getEngineType();
        dto.body = car.getBody();
        dto.transmissie = car.getTransmissie();
        dto.fuel = car.getFuel();

        return dto;
    }

    public Car DtoToCar(CarDto carDto){
        Car car = new Car();

        car.setBrand(carDto.brand);
        car.setModel(carDto.model);
        car.setYearOfBuild(carDto.yearOfBuild);
        car.setColor(carDto.color);
        car.setLicensePlate(carDto.licensePlate);
        car.setMileage(carDto.mileAge);
        car.setEngineType(carDto.engineType);
        car.setBody(carDto.body);
        car.setTransmissie(carDto.transmissie);
        car.setFuel(carDto.fuel);
        return car
    }
}
