package Service;

import Exceptions.RecordNotFoundException;
import Models.Data.Car;
import Models.Data.CarOwner;
import Models.Data.CarOwnerKey;
import Models.Data.CustomerAccount;
import Repository.CarOwnerRepository;
import Repository.CarRepository;
import Repository.CustomerAccountRepository;
import dto.output.CarOutputDto;
import dto.output.CustomerAccountOutputDto;

import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;



@Service
public class CarOwnerService {

    private final CarRepository carRepository;

    private final CustomerAccountRepository customerAccountRepository;

    private final CarOwnerRepository carOwnerRepository;

    public CarOwnerService(CarRepository carRepository, CustomerAccountRepository customerAccountRepository, CarOwnerRepository carOwnerRepository) {
        this.carRepository = carRepository;
        this.customerAccountRepository = customerAccountRepository;
        this.carOwnerRepository = carOwnerRepository;
    }

    public Collection<CustomerAccountOutputDto> getAccountByCarId(Long carId) {
        Collection<CustomerAccountOutputDto> dtoCollection = new HashSet<>();
        Collection<CarOwner> owners = carOwnerRepository.findOwnerByCar(carId);
        for (CarOwner carOwner : owners) {
            CustomerAccount customerAccount = carOwner.getCustomerAccount();
            CustomerAccountOutputDto accountAllOutputDto = new CustomerAccountOutputDto();

            accountAllOutputDto.setId(customerAccount.getId());
            accountAllOutputDto.setCustomerFirstName(customerAccount.getCustomerFirstName());
            accountAllOutputDto.setCustomerLastName(customerAccount.getCustomerLastName());
            accountAllOutputDto.setCostumerNumber(customerAccount.getCustomerNumber());
            accountAllOutputDto.setAddress(customerAccount.getAddress());
            accountAllOutputDto.setPhoneNumber(customerAccount.getPhoneNumber());
            accountAllOutputDto.setBillingAddress(customerAccount.getBillingAddress());
            accountAllOutputDto.setBankAccountNumber(customerAccount.getBankAccountNumber());

            dtoCollection.add(accountAllOutputDto);
        }
        return dtoCollection;
    }

    public Collection<CarOutputDto> getCarByCustomerId(Long OwnerId) {
        Collection<CarOutputDto> dtos = new HashSet<>();
        List<CarOwner> carOwners = carOwnerRepository.findAllByCarsId(OwnerId);
        for (CarOwner carOwner : carOwners) {
            Car car = carOwner.getCar();
            var dto = new CarOutputDto();

            dto.setId(car.getId());
            dto.setBrand(car.getBrand());
            dto.setModel(car.getModel());
            dto.setYearOfBuild(car.getYearOfBuild());
            dto.setColor(car.getColor());
            dto.setLicensePlate(car.getLicensePlate());
            dto.setMileage(car.getMileage());
            dto.setEngineType(car.getEngineType());
            dto.setBody(car.getBody());
            dto.setTransmission(car.getTransmission());
            dto.setFuel(car.getFuel());

            dtos.add(dto);

        }
        return dtos;
    }

    public CarOwnerKey addAccountToCar(Long carId, Long ownerId) {
        var carOwner = new CarOwner();
        var optionalCar = carRepository.findById(carId);
        var optionalAccount = customerAccountRepository.findById(ownerId);

        if (optionalCar.isPresent()) {
            throw new RecordNotFoundException("Can find" + optionalCar + "please enter another id");
        }
        var car = optionalCar.get();
        if (optionalAccount.isPresent()) {
            throw new RecordNotFoundException("Can find" + optionalAccount + "please enter another id");
        }
        var account = optionalAccount.get();
        carOwner.setCar(car);
        carOwner.setCustomerAccount(account);
        CarOwnerKey id = new CarOwnerKey(carId, ownerId);
        carOwner.setId(id);
        carOwnerRepository.save(carOwner);
        return id;
    }
}
