package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Exceptions.CarNotFoundException;
import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.Car;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.Repository.CustomerAccountRepository;
import nl.novi.Eindopdracht.dto.input.CarDto;
import nl.novi.Eindopdracht.dto.output.CarOutputDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CarService {

    private final CarRepository carRepos;

    private final CustomerAccountRepository cARepos;





    public CarService(CarRepository carRepos,CustomerAccountRepository cARepos) {
        this.carRepos = carRepos;
        this.cARepos = cARepos;
    }

    public Long createCar(CarDto carDto) {
        Car car = DtoToCar(carDto);

        carRepos.save(car);
        return car.getId();
    }

    public List<CarOutputDto>getAllCars(){
        List<CarOutputDto> collection = new ArrayList<>();
        List<Car> list= carRepos.findAll();
        for (Car car: list){
            collection.add(carToDto(car));
        }
        return collection;
    }

    public CarOutputDto getCarById(long id){
        Optional<Car>carOptional = carRepos.findById(id);
        if (!carOptional.isPresent()){
           throw new RecordNotFoundException("Can find car please enter another id");
        }
        else {
            Car c = carOptional.get();
            return carToDto(c);
        }
    }


    public CarDto updateCarMileage(long id , Integer mileage ){
        Optional<Car> optionalCar = carRepos.findById(id);
        if(optionalCar.isPresent()){
             Car car = optionalCar.get();
            car.setMileage(mileage);
            carRepos.save(car);
        }else {
            throw new RecordNotFoundException("Can find "+ optionalCar + " please enter a anther onwername");
        }
        return null;
    }

    public CarDto updateEngineType(long id , String engineType ){
        Optional<Car> optionalCar = carRepos.findById(id);
        if(optionalCar.isPresent()){
            Car car = optionalCar.get();
            car.setEngineType(engineType);
            carRepos.save(car);
        }else {
            throw new RecordNotFoundException("Can find "+ optionalCar + " please enter a anther onwername");
        }
        return null;
    }


    public String deleteCarById(long id) {
        if (!carRepos.existsById(id)) {
            throw new CarNotFoundException("Car with id:" + id + "is not found");
        } else {
            long count = carRepos.count();
            carRepos.deleteById(id);
            return "You delete" + count + "in the id" + id;
        }
    }
    public String deleteAllCars(){
        long count = carRepos.count();
        carRepos.deleteAll();
        return "You deleted "+ count + "cars";
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
        dto.transmission = car.getTransmission();
        dto.fuel = car.getFuel();
        dto.carOwners = car.getCarOwner();

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
        car.setTransmission(carDto.transmission);
        car.setFuel(carDto.fuel);
        car.setCarOwner(carDto.carOwners);
        return car;
    }



}
