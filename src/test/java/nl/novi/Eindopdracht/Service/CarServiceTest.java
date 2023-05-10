package nl.novi.Eindopdracht.Service;

import nl.novi.Eindopdracht.Models.Data.CarBrand;
import nl.novi.Eindopdracht.Models.Data.CarModel;
import nl.novi.Eindopdracht.Models.Data.Car;
import nl.novi.Eindopdracht.Models.Data.CustomerAccount;
import nl.novi.Eindopdracht.Repository.CarRepository;
import nl.novi.Eindopdracht.Repository.CustomerAccountRepository;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CarServiceTest {
    @Mock
    CarRepository carRepos;

    @Mock
    CustomerAccountRepository accountRepos;

    @InjectMocks
    CarService carService;

    @Captor
    ArgumentCaptor<Car> captor;

    CustomerAccount account1;
    CustomerAccount account2;
    CustomerAccount account3;

    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void setUp(){


        account1= new CustomerAccount(1L,"Adriaan de Wit","Adriaan","De wit","00003","Prinsessenweg 19","0623123421","Prinsessenweg 19","nl21INGB 5555 555 05", Collections.emptyList());
        account2 = new CustomerAccount(2L,"Hendrick lopers","Hendrick ","Lopers","00002","DaltonLaan 21", "06123456778","Daltonlaan 21", "nl21 55553218", Collections.emptyList());
        account3 = new CustomerAccount(3L,"Jan Vermeer", "Jan", "Vermeer","00005","Biltstraat 3", "06789344561","Biltstraat 3", "nl21 INGB 343321",Collections.emptyList());

        car1 = new Car(1L, CarBrand.VOLKSWAGEN, CarModel.GOLF, LocalDate.of(2020,4,12),"Yellow","D-899-PP",10202, "1.2 tsi","hatchback","menual", "bezine",List.of(account1,account2));
        car2 = new Car(1L,"Audi","A3", LocalDate.of(2022,8,2),"Red","D-710-PP",150123, "1.5 tsi","hatchback","menual", "bezine",List.of(account3,account2));
        car3 = new Car(1L,"Audi","A4", LocalDate.of(2018,2,5),"Blue","G-810-DD",501, "1.8 tsi","station","menual", "bezine",List.of(account1,account3));
    }





    @Test
    void createCar() {
    }

    @Test
    void getAllCars() {
        when(carRepos.findAll()).thenReturn(List.of(car1,car2,car3));

        List<CarOutputDto> carsFound= carService.getAllCars();

        assertEquals(car1.getBrand(),carsFound.get(0).brand);
        assertEquals(car2.getModel(),carsFound.get(1).model);
        assertEquals(car3.getBrand(),carsFound.get(2).brand);
    }

    @Test
    void getCarById() {

    }

    @Test
    void updateCarMileage() {
    }

    @Test
    void updateEngineType() {
    }

    @Test
    void deleteCarById() {
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