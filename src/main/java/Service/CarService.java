package Service;

import Models.Data.Car;
import Repository.CarRepository;
import Repository.CustomerAccountRepository;
import dto.input.CarDto;
import dto.output.CarOutputDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarService {
    @Autowired
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

    public CarOutputDto getCarById(Long id){
        Optional<Car>car = carRepos.findById(id);
        if (car.isEmpty()){
           throw new //RecordnotFoundException
        }
        else {
            Car c = car.get();
            return carToDto(c);
        }
    }

    public CarOutputDto getOwnerById(String owername){
        Optional<Car>carOptional = carRepos.find

    }

    public CarDto updateCarMileage(long id , Integer mileage ){
        var optionalCar = carRepos.findById(id);
        if(optionalCar.isPresent()){
            var car = optionalCar.get();
            car.setMileage(mileage);
            carRepos.save(car);
        }else {
            throw new //recordnotfounexception;
        }
    }

    public CarDto updateEngineType(long id , String engineType ){
        var optionalCar = carRepos.findById(id);
        if(optionalCar.isPresent()){
            var car = optionalCar.get();
            car.setEngineType(engineType);
            carRepos.save(car);
        }else {
            throw new //recordnotfounexception;
        }
    }



    public void addOwnerIdToCarId(long id, long ownerId) {
        var optionalCar =carRepos.findById(id);
        var optionalOwner = cARepos.findById(ownerId);

        if(optionalCar.isPresent()&&optionalOwner.isPresent(){

            var car= optionalCar.get();
            var owner = optionalOwner.get();
            Car.setOwner(owner);// nog toegevoegd worden als relatie
            carRepos.save(car);
        }
        else    {
        throw new //RecordnotfoundException
     }
    }




    public void deleteCarById(long id) {
        carRepos.deleteById(id);
        }

    public void deleteAllCars(){
        carRepos.deleteAll();
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
        return car;
    }



}
