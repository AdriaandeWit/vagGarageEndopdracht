package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Models.Colors;
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
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

    @BeforeEach
    void setUp(){


        account1= new CustomerAccount(1L,"Adriaan de Wit","Adriaan","De wit","Prinsessenweg 19","0623123421","Prinsessenweg 19","nl21INGB 5555 555 05");
        account2 = new CustomerAccount(2L,"Hendrick lopers","Hendrick ","Lopers","DaltonLaan 21", "06123456778","Daltonlaan 21", "nl21 55553218");
        account3 = new CustomerAccount(3L,"Jan Vermeer", "Jan", "Vermeer","Biltstraat 3", "06789344561","Biltstraat 3", "nl21 INGB 343321");

        car1 = new Car(1L, CarBrand.VOLKSWAGEN, CarModel.GOLF, LocalDate.of(2020,4,12), Colors.BLACK,"D-899-PP",10202, EngineType.TSI,Body.HATCHBACK,Transmission.Automatic,Fuel.Petrol,account1);
        car2 = new Car(2L,CarBrand.AUDI,CarModel.A3, LocalDate.of(2022,8,2),Colors.BROWN,"D-710-PP",150123, EngineType.TDI,Body.HATCHBACK,Transmission.Manual, Fuel.DIESEL,account2);
        car3 = new Car(3L,CarBrand.AUDI,CarModel.A4, LocalDate.of(2018,2,5),Colors.SILVER,"G-810-DD",501, EngineType.TSI,Body.SEDAN,Transmission.SEMIAUTOMATIC , Fuel.Petrol,account3);
        car4 = new Car(4L,CarBrand.SEAT,CarModel.LEON,LocalDate.of(2020,8,2),Colors.GRAY,"G-703-DF",23761,EngineType.TSI,Body.STATIONWAGON,Transmission.Automatic,Fuel.Petrol,account1);
    }




    @Test
    void createCar() {
    }

    @Test
    void testGetAllCars() {



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

    // TODO: 11/05/2023 Kijk met mark morgen naar!
 /*   @Test
    void addAccountToCar() {
        when(carRepos.findByLicensePlate(car2.getLicensePlate())).thenReturn(Optional.of(car2));
        when(cARepos.findAccountByCustomerName(account1.getCustomerName())).thenReturn(Optional.of(account1));

        carService.addAccountToCar(car2.getLicensePlate(),account1.getCustomerName());

        verify(carRepos,times(1)).save(argumentCaptor.capture());

        Car capture = argumentCaptor.getValue();

        assertEquals(car2.getAccount());capture.getAccount();

    }
*/
    @Test
    void updateCarMileage() {
//arrange
        String licensePlate = car1.getLicensePlate();
        Integer mileage = car1.getMileage();
        Car car = new Car(licensePlate,mileage);
        when(carRepos.findByLicensePlate(licensePlate)).thenReturn(Optional.of(car));
//act
        CarDto resulte = carService.updateCarMileage(licensePlate, 1500);

//asserts
        verify(carRepos,times(1)).save(car);
        assertEquals(1500,car.getMileage().intValue());
        assertNull(resulte);


    }

    @Test
    void updateEngineType() {
    }

    @Test
    void deleteCarByLicensePlate() {
    }

    @Test
    void deleteAllCars() {
    }

    @Test
    void carToDto() {
    }

    @Test
    void dtoToCar() {
    }
}