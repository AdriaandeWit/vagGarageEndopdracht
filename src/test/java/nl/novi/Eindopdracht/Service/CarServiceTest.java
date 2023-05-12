package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Enum.*;
import nl.novi.Eindopdracht.Models.Data.*;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.Repository.CustomerAccountRepository;

import nl.novi.Eindopdracht.dto.input.CarDto;
import nl.novi.Eindopdracht.dto.output.CarOutputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CarServiceTest {
    @Mock
    CarRepository carRepos;

    @Mock
    CustomerAccountRepository cARepos;

    @InjectMocks
    CarService carService;

   @Captor
   ArgumentCaptor<Car> argumentCaptor;


    CustomerAccount account1;
    CustomerAccount account2;
    CustomerAccount account3;

    Car car1;
    Car car2;
    Car car3;
    Car car4;

    CarDto carDto;

    @BeforeEach
    void setUp(){


        account1= new CustomerAccount(1L,"Adriaan de Wit","Adriaan","De wit","Prinsessenweg 19","0623123421","Prinsessenweg 19","nl21INGB 5555 555 05");
        account2 = new CustomerAccount(2L,"Hendrick lopers","Hendrick ","Lopers","DaltonLaan 21", "06123456778","Daltonlaan 21", "nl21 55553218");
        account3 = new CustomerAccount(3L,"Jan Vermeer", "Jan", "Vermeer","Biltstraat 3", "06789344561","Biltstraat 3", "nl21 INGB 343321");

        car1 = new Car( CarBrand.VOLKSWAGEN, CarModel.GOLF, LocalDate.of(2020,4,12), Colors.BLACK,"D-899-PP",10202, EngineType.TSI, Body.HATCHBACK,Transmission.Automatic,Fuel.Petrol,account1);
        car2 = new Car(CarBrand.AUDI,CarModel.A3, LocalDate.of(2022,8,2),Colors.BROWN,"D-710-PP",150123, EngineType.TDI,Body.HATCHBACK,Transmission.Manual, Fuel.DIESEL,account2);
        car3 = new Car(CarBrand.AUDI,CarModel.A4, LocalDate.of(2018,2,5),Colors.SILVER,"G-810-DD",501, EngineType.TSI,Body.SEDAN,Transmission.SEMIAUTOMATIC , Fuel.Petrol,account3);
        car4 = new Car(CarBrand.SEAT,CarModel.LEON,LocalDate.of(2020,8,2),Colors.GRAY,"G-703-DF",23761,EngineType.TSI,Body.STATIONWAGON,Transmission.Automatic,Fuel.Petrol,account1);

        carDto = new CarDto();
        carDto.setBrand(CarBrand.SEAT);
        carDto.setModel(CarModel.LEON);
        carDto.setYearOfBuild(LocalDate.of(2020,8,2));
        carDto.setColor(Colors.GRAY);
        carDto.setLicensePlate("G-703-DF");
        carDto.setMileAge(23761);
        carDto.setEngineType(EngineType.TSI);
        carDto.setBody(Body.STATIONWAGON);
        carDto.setTransmission(Transmission.Automatic);
        carDto.setFuel(Fuel.Petrol);

    }




    @Test
    void createCar() {

        when(carRepos.save(car4)).thenReturn(car4);
        carService.createCar(carDto);

        verify(carRepos, times(1)).save(argumentCaptor.capture());
        Car car = argumentCaptor.getValue();

        assertEquals(car4.getBrand(),car.getBrand());
        assertEquals(car4.getModel(),car.getModel());
        assertEquals(car4.getYearOfBuild(),car.getYearOfBuild());
        assertEquals(car4.getColor(),car.getColor());
        assertEquals(car4.getLicensePlate(),car.getLicensePlate());
        assertEquals(car4.getMileAge(),car.getMileAge());
        assertEquals(car4.getEngineType(),car.getEngineType());
        assertEquals(car4.getBody(),car.getBody());
        assertEquals(car4.getTransmission(),car.getTransmission());
        assertEquals(car4.getFuel(),car.getFuel());

    }

    @Test
    void testGetAllCars() {

      when(carRepos.findAll()).thenReturn(List.of(car1,car2,car3,car4));

      List<Car> cars = carRepos.findAll();
      List<CarOutputDto>dtoList = carService.getAllCars();

      assertEquals(cars.get(0).getLicensePlate(),dtoList.get(0).licensePlate);
      assertEquals(cars.get(0).getBrand(),dtoList.get(0).brand);
      assertEquals(cars.get(1).getLicensePlate(),dtoList.get(1).licensePlate);
      assertEquals(cars.get(1).getBrand(),dtoList.get(1).brand);
      assertEquals(cars.get(2).getLicensePlate(),dtoList.get(2).licensePlate);
      assertEquals(cars.get(2).getBrand(),dtoList.get(2).brand);
      assertEquals(cars.get(3).getLicensePlate(),dtoList.get(3).licensePlate);
      assertEquals(cars.get(3).getBrand(),dtoList.get(3).brand);

    }

    @Test
    void getCarByCarLicensePlate() {

        when(carRepos.findByLicensePlate(car1.getLicensePlate())).thenReturn(Optional.ofNullable(car1));

        Optional<Car> car = carRepos.findByLicensePlate(car1.getLicensePlate());


        assertEquals(car1.getBrand(), car.get().getBrand());
        assertEquals(car1.getModel(), car.get().getModel());
    }

    @Test
    void getAllCarsByCustomerName() {
        when(carRepos.findAll()).thenReturn(List.of(car1,car2,car3));

        List<Car> cars = carRepos.findAll();
        List<CarOutputDto> carsFound= carService.getAllCars();

        assertEquals(cars.get(0).getBrand(),carsFound.get(0).brand);
        assertEquals(cars.get(0).getModel(),carsFound.get(0).model);
        assertEquals(cars.get(1).getBrand(),carsFound.get(1).brand);
        assertEquals(cars.get(1).getModel(),carsFound.get(1).model);
        assertEquals(cars.get(2).getBrand(),carsFound.get(2).brand);
        assertEquals(cars.get(2).getModel(),carsFound.get(2).model);
    }


   @Test
    void addAccountToCar() {
        when(carRepos.findByLicensePlate(car2.getLicensePlate())).thenReturn(Optional.of(car2));
        when(cARepos.findAccountByCustomerName(account1.getCustomerName())).thenReturn(Optional.of(account1));

        carService.addAccountToCar(car2.getLicensePlate(),account1.getCustomerName());

        verify(carRepos,times(1)).save(argumentCaptor.capture());

        Car capture = argumentCaptor.getValue();

        assertEquals(car2.getAccount(),capture.getAccount());

    }

    @Test
    void updateCarMileage() {
//arrange

        String licensePlate = car1.getLicensePlate();

        when(carRepos.findByLicensePlate(licensePlate)).thenReturn(Optional.of(car1));
        when(carRepos.save(car1)).thenReturn(car1);
//act
        carService.updateCarMileage(licensePlate, 1500);

//asserts
        verify(carRepos,times(1)).save(car1);
        assertEquals(licensePlate,car1.getLicensePlate());
        assertEquals(1500,car1.getMileAge().intValue());





    }

    @Test
    void updateEngineType() {

        //arrange
        when(carRepos.findByLicensePlate(car2.getLicensePlate())).thenReturn(Optional.of(car2));
        when(carRepos.save(car2)).thenReturn(car2);
        //act
         carService.updateEngineType(car2.getLicensePlate(), EngineType.tSFI);

        verify(carRepos,times(1)).save(car2);

        assertEquals(EngineType.tSFI,car2.getEngineType());

    }

    @Test
    void deleteCarByLicensePlate() {

        //arrange
        when(carRepos.findByLicensePlate(car3.getLicensePlate())).thenReturn(Optional.of(car3));


        //act
        carService.deleteCarByLicensePlate(car3.getLicensePlate());
        //asserts
        verify(carRepos).deleteByLicensePlate(car3.getLicensePlate());
    }

    @Test
    void deleteAllCars() {

       carService.deleteAllCars();

       verify(carRepos).deleteAll();

    }

    @Test
    void carToDto() {

        when(carRepos.save(car1)).thenReturn(car1);

        CarOutputDto actualDto = carService.carToDto(car1);

        assertEquals(car1.getBrand(),actualDto.brand);
        assertEquals(car1.getModel(),actualDto.model);
        assertEquals(car1.getYearOfBuild(),actualDto.yearOfBuild);
        assertEquals(car1.getColor(),actualDto.color);
        assertEquals(car1.getLicensePlate(),actualDto.licensePlate);
        assertEquals(car1.getMileAge(),actualDto.mileAge);
        assertEquals(car1.getEngineType(),actualDto.engineType);
        assertEquals(car1.getTransmission(),actualDto.transmission);

    }

    @Test
    void dtoToCar() {

        when(carRepos.save(car1)).thenReturn(car1);



        Car car1 = carService.transferDtoToCar(carDto);


        assertEquals(car1.getBrand(),carDto.brand);
        assertEquals(car1.getModel(),carDto.model);
        assertEquals(car1.getYearOfBuild(),carDto.yearOfBuild);
        assertEquals(car1.getColor(),carDto.color);
        assertEquals(car1.getLicensePlate(),carDto.licensePlate);
        assertEquals(car1.getMileAge(),carDto.mileAge);
        assertEquals(car1.getEngineType(),carDto.engineType);
        assertEquals(car1.getTransmission(),carDto.transmission);

    }

}