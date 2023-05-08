package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Exceptions.RecordNotFoundException;
import nl.novi.Eindopdracht.Models.Data.Car;
import nl.novi.Eindopdracht.Models.Data.CarOwner;
import nl.novi.Eindopdracht.Models.Data.CarOwnerKey;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;
import nl.novi.Eindopdracht.Repository.CarOwnerRepository;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.Repository.CustomerAccountRepository;
import nl.novi.Eindopdracht.dto.output.CarOutputDto;
import nl.novi.Eindopdracht.dto.output.CustomerAccountOutputDto;

import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


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
        Collection<CarOwner> owners = carOwnerRepository.findAllByCar_Id(carId);
        for (CarOwner carOwner : owners) {
            CustomerAccount account = carOwner.getCustomerAccount();
            CustomerAccountOutputDto accountAllOutputDto = new CustomerAccountOutputDto();

            accountAllOutputDto.setId(account.getId());
            accountAllOutputDto.setCustomerName(account.getCustomerName());
            accountAllOutputDto.setFirstName(account.getFirstName());
            accountAllOutputDto.setLastName(account.getLastName());
            accountAllOutputDto.setCustomerNumber(account.getCustomerNumber());
            accountAllOutputDto.setAddress(account.getAddress());
            accountAllOutputDto.setPhoneNumber(account.getPhoneNumber());
            accountAllOutputDto.setBillingAddress(account.getBillingAddress());
            accountAllOutputDto.setBankAccountNumber(account.getBankAccountNumber());

            dtoCollection.add(accountAllOutputDto);
        }
        return dtoCollection;
    }

    public Collection<CarOutputDto> getCarByCustomerId(Long OwnerId) {
        Collection<CarOutputDto> dtos = new HashSet<>();
        List<CarOwner> carOwners = carOwnerRepository.findAllByCustomerAccount_Id(OwnerId);
        for (CarOwner carOwner : carOwners) {
            Car car = carOwner.getCar();
            CarOutputDto dto = new CarOutputDto();

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
        CarOwner carOwner = new CarOwner();
        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<CustomerAccount> optionalAccount = customerAccountRepository.findById(ownerId);

        if (optionalCar.isPresent()) {
            throw new RecordNotFoundException("Can find" + optionalCar + "please enter another id");
        }
        Car car = optionalCar.get();
        if (optionalAccount.isPresent()) {
            throw new RecordNotFoundException("Can find" + optionalAccount + "please enter another id");
        }
        CustomerAccount account = optionalAccount.get();
        carOwner.setCar(car);
        carOwner.setCustomerAccount(account);
        CarOwnerKey id = new CarOwnerKey(carId, ownerId);
        carOwner.setId(id);
        carOwnerRepository.save(carOwner);
        return id;
    }
}
