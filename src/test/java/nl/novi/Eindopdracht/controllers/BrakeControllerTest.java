package nl.novi.Eindopdracht.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.novi.Eindopdracht.Controllers.BrakeController;
import nl.novi.Eindopdracht.Models.Data.CarParts.Brakes;
import nl.novi.Eindopdracht.Service.BrakeService;
import nl.novi.Eindopdracht.Service.CarService;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.BrakesDto;
import nl.novi.Eindopdracht.dto.output.CarPartsDto.BrakesOutputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BrakeController.class)
@AutoConfigureMockMvc(addFilters = false)
class BrakeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BrakeService brakeService;

    @MockBean
    private CarService carService;
    BrakesDto brakesDto1;

    BrakesDto brakesDto2;

    BrakesDto brakesDto3;

    Brakes brake1;

    Brakes brake2;

    Brakes brake3;
    BrakesOutputDto brakesOutputDto1;
    BrakesOutputDto brakesOutputDto2;
    BrakesOutputDto brakesOutputDto3;


    @BeforeEach
    void setUp() {
        brakesDto1 = new BrakesDto();
        brakesDto1.setId(1L);
        brakesDto1.setPartName("Brake Part");
        brakesDto1.setPartNumber("123456");
        brakesDto1.setPrice(9.99);
        brakesDto1.setAmountOfParts(1);
        brakesDto1.setOuterDiameter(10.5);
        brakesDto1.setCenterDiameter(5.5);
        brakesDto1.setHeight(3.0);
        brakesDto1.setMinThickness(2.0);
        brakesDto1.setSurface(50.0);
        brakesDto1.setDiscThickness(1.5);
        brakesDto1.setBoreTypeNumberOfHoles("Type A, 4 holes");
        brakesDto1.setWheelStudDiameter(6.0);
        brakesDto1.setWithoutWheelMountingBolts(false);
        brakesDto1.setWithoutWheelHub(true);

        brakesDto2 = new BrakesDto();
        brakesDto2.setId(2L);
        brakesDto2.setPartName("Brake Part 2");
        brakesDto2.setPartNumber("789012");
        brakesDto2.setPrice(14.99);
        brakesDto2.setAmountOfParts(2);
        brakesDto2.setOuterDiameter(11.0);
        brakesDto2.setCenterDiameter(6.0);
        brakesDto2.setHeight(3.5);
        brakesDto2.setMinThickness(2.5);
        brakesDto2.setSurface(60.0);
        brakesDto2.setDiscThickness(1.8);
        brakesDto2.setBoreTypeNumberOfHoles("Type B, 5 holes");
        brakesDto2.setWheelStudDiameter(6.5);
        brakesDto2.setWithoutWheelMountingBolts(true);
        brakesDto2.setWithoutWheelHub(false);

        brakesDto3 = new BrakesDto();
        brakesDto3.setId(3L);
        brakesDto3.setPartName("Brake Part 3");
        brakesDto3.setPartNumber("345678");
        brakesDto3.setPrice(19.99);
        brakesDto3.setAmountOfParts(1);
        brakesDto3.setOuterDiameter(10.0);
        brakesDto3.setCenterDiameter(5.0);
        brakesDto3.setHeight(2.5);
        brakesDto3.setMinThickness(2.2);
        brakesDto3.setSurface(55.0);
        brakesDto3.setDiscThickness(1.6);
        brakesDto3.setBoreTypeNumberOfHoles("Type C, 6 holes");
        brakesDto3.setWheelStudDiameter(6.2);
        brakesDto3.setWithoutWheelMountingBolts(false);
        brakesDto3.setWithoutWheelHub(true);

        brake1 = new Brakes();
        brake1.setId(brakesDto1.getId());
        brake1.setPartName(brakesDto1.getPartName());
        brake1.setPartNumber(brakesDto1.getPartNumber());
        brake1.setPrice(brakesDto1.getPrice());
        brake1.setAmountOfParts(brakesDto1.getAmountOfParts());
        brake1.setOuterDiameter(brakesDto1.getOuterDiameter());
        brake1.setCenterDiameter(brakesDto1.getCenterDiameter());
        brake1.setHeight(brakesDto1.getHeight());
        brake1.setMinThickness(brakesDto1.getMinThickness());
        brake1.setSurface(brakesDto1.getSurface());
        brake1.setDiscThickness(brakesDto1.getDiscThickness());
        brake1.setBoreTypeNumberOfHoles(brakesDto1.getBoreTypeNumberOfHoles());
        brake1.setWheelStudDiameter(brakesDto1.getWheelStudDiameter());
        brake1.setWithoutWheelMountingBolts(brakesDto1.getWithoutWheelMountingBolts());
        brake1.setWithoutWheelHub(brakesDto1.getWithoutWheelHub());

        brake2 = new Brakes();
        brake2.setId(brakesDto2.getId());
        brake2.setPartName(brakesDto2.getPartName());
        brake2.setPartNumber(brakesDto2.getPartNumber());
        brake2.setPrice(brakesDto2.getPrice());
        brake2.setAmountOfParts(brakesDto2.getAmountOfParts());
        brake2.setOuterDiameter(brakesDto2.getOuterDiameter());
        brake2.setCenterDiameter(brakesDto2.getCenterDiameter());
        brake2.setHeight(brakesDto2.getHeight());
        brake2.setMinThickness(brakesDto2.getMinThickness());
        brake2.setSurface(brakesDto2.getSurface());
        brake2.setDiscThickness(brakesDto2.getDiscThickness());
        brake2.setBoreTypeNumberOfHoles(brakesDto2.getBoreTypeNumberOfHoles());
        brake2.setWheelStudDiameter(brakesDto2.getWheelStudDiameter());
        brake2.setWithoutWheelMountingBolts(brakesDto2.getWithoutWheelMountingBolts());
        brake2.setWithoutWheelHub(brakesDto2.getWithoutWheelHub());

        brake3 = new Brakes();
        brake3.setId(brakesDto3.getId());
        brake3.setPartName(brakesDto3.getPartName());
        brake3.setPartNumber(brakesDto3.getPartNumber());
        brake3.setPrice(brakesDto3.getPrice());
        brake3.setAmountOfParts(brakesDto3.getAmountOfParts());
        brake3.setOuterDiameter(brakesDto3.getOuterDiameter());
        brake3.setCenterDiameter(brakesDto3.getCenterDiameter());
        brake3.setHeight(brakesDto3.getHeight());
        brake3.setMinThickness(brakesDto3.getMinThickness());
        brake3.setSurface(brakesDto3.getSurface());
        brake3.setDiscThickness(brakesDto3.getDiscThickness());
        brake3.setBoreTypeNumberOfHoles(brakesDto3.getBoreTypeNumberOfHoles());
        brake3.setWheelStudDiameter(brakesDto3.getWheelStudDiameter());
        brake3.setWithoutWheelMountingBolts(brakesDto3.getWithoutWheelMountingBolts());
        brake3.setWithoutWheelHub(brakesDto3.getWithoutWheelHub());

        brakesOutputDto1 = new BrakesOutputDto();
        brakesOutputDto1.setId(brake1.getId());
        brakesOutputDto1.setPartName(brake1.getPartName());
        brakesOutputDto1.setPartNumber(brake1.getPartNumber());
        brakesOutputDto1.setPrice(brake1.getPrice());
        brakesOutputDto1.setAmountOfParts(brake1.getAmountOfParts());
        brakesOutputDto1.setOuterDiameter(brake1.getOuterDiameter());
        brakesOutputDto1.setCenterDiameter(brake1.getCenterDiameter());
        brakesOutputDto1.setHeight(brake1.getHeight());
        brakesOutputDto1.setMinThickness(brake1.getMinThickness());
        brakesOutputDto1.setSurface(brake1.getSurface());
        brakesOutputDto1.setDiscThickness(brake1.getDiscThickness());
        brakesOutputDto1.setBoreTypeNumberOfHoles(brake1.getBoreTypeNumberOfHoles());
        brakesOutputDto1.setWheelStudDiameter(brake1.getWheelStudDiameter());
        brakesOutputDto1.setWithoutWheelMountingBolts(brake1.getWithoutWheelMountingBolts());
        brakesOutputDto1.setWithoutWheelHub(brake1.getWithoutWheelHub());

        brakesOutputDto2 = new BrakesOutputDto();
        brakesOutputDto2.setId(brake2.getId());
        brakesOutputDto2.setPartName(brake2.getPartName());
        brakesOutputDto2.setPartNumber(brake2.getPartNumber());
        brakesOutputDto2.setPrice(brake2.getPrice());
        brakesOutputDto2.setAmountOfParts(brake2.getAmountOfParts());
        brakesOutputDto2.setOuterDiameter(brake2.getOuterDiameter());
        brakesOutputDto2.setCenterDiameter(brake2.getCenterDiameter());
        brakesOutputDto2.setHeight(brake2.getHeight());
        brakesOutputDto2.setMinThickness(brake2.getMinThickness());
        brakesOutputDto2.setSurface(brake2.getSurface());
        brakesOutputDto2.setDiscThickness(brake2.getDiscThickness());
        brakesOutputDto2.setBoreTypeNumberOfHoles(brake2.getBoreTypeNumberOfHoles());
        brakesOutputDto2.setWheelStudDiameter(brake2.getWheelStudDiameter());
        brakesOutputDto2.setWithoutWheelMountingBolts(brake2.getWithoutWheelMountingBolts());
        brakesOutputDto2.setWithoutWheelHub(brake2.getWithoutWheelHub());

        brakesOutputDto3 = new BrakesOutputDto();
        brakesOutputDto3.setId(brake3.getId());
        brakesOutputDto3.setPartName(brake3.getPartName());
        brakesOutputDto3.setPartNumber(brake3.getPartNumber());
        brakesOutputDto3.setPrice(brake3.getPrice());
        brakesOutputDto3.setAmountOfParts(brake3.getAmountOfParts());
        brakesOutputDto3.setOuterDiameter(brake3.getOuterDiameter());
        brakesOutputDto3.setCenterDiameter(brake3.getCenterDiameter());
        brakesOutputDto3.setHeight(brake3.getHeight());
        brakesOutputDto3.setMinThickness(brake3.getMinThickness());
        brakesOutputDto3.setSurface(brake3.getSurface());
        brakesOutputDto3.setDiscThickness(brake3.getDiscThickness());
        brakesOutputDto3.setBoreTypeNumberOfHoles(brake3.getBoreTypeNumberOfHoles());
        brakesOutputDto3.setWheelStudDiameter(brake3.getWheelStudDiameter());
        brakesOutputDto3.setWithoutWheelMountingBolts(brake3.getWithoutWheelMountingBolts());
        brakesOutputDto3.setWithoutWheelHub(brake3.getWithoutWheelHub());
    }


    @Test
    void createBrake() throws Exception {
        BrakesDto brakesDto4 = new BrakesDto();
        brakesDto4.setPartName("Brake Part");
        brakesDto4.setPartNumber("123456");
        brakesDto4.setPrice(9.99);
        brakesDto4.setAmountOfParts(1);
        brakesDto4.setOuterDiameter(10.5);
        brakesDto4.setCenterDiameter(5.5);
        brakesDto4.setHeight(3.0);
        brakesDto4.setMinThickness(2.0);
        brakesDto4.setSurface(50.0);
        brakesDto4.setDiscThickness(1.5);
        brakesDto4.setBoreTypeNumberOfHoles("Type A, 4 holes");
        brakesDto4.setWheelStudDiameter(6.0);
        brakesDto4.setWithoutWheelMountingBolts(false);
        brakesDto4.setWithoutWheelHub(true);

        Long id = 1L;
        given(brakeService.createBrake(brakesDto4)).willReturn(id);



        mockMvc.perform(MockMvcRequestBuilders.post("/car/parts/brakes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(brakesDto4)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/create/" + id))
                .andExpect((ResultMatcher) jsonPath("id").value(id))
                .andExpect((ResultMatcher) jsonPath("partName").value("Brake Part"))
                .andExpect((ResultMatcher) jsonPath("partNumber").value("123456"))
                .andExpect((ResultMatcher) jsonPath("price").value(9.99))
                .andExpect((ResultMatcher) jsonPath("amountOfParts").value(1))
                .andExpect((ResultMatcher) jsonPath("wheelStudDiameter").value(6.0));


    }



    @Test
    void getAllBrakes() throws Exception {
        given(brakeService.getAllBrakes()).willReturn(List.of(brakesOutputDto1,brakesOutputDto2,brakesOutputDto3));


        mockMvc.perform(get("/car/find/all"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].id").value(1L))
                .andExpect((ResultMatcher) jsonPath("$[0].partName").value("Brake Part"))
                .andExpect((ResultMatcher) jsonPath("$[0].partNumber").value("123456"))
                .andExpect((ResultMatcher) jsonPath("$[0].price").value(9.99))
                .andExpect((ResultMatcher) jsonPath("$[0].amountOfParts").value(1))
                .andExpect((ResultMatcher) jsonPath("$[0].outerDiameter").value(10.5))
                .andExpect((ResultMatcher) jsonPath("$[0].centerDiameter").value(5.5))
                .andExpect((ResultMatcher) jsonPath("$[0].boreTypeNumberOfHoles").value("Type A, 4 holes"))
                .andExpect((ResultMatcher) jsonPath("$[0].wheelStudDiameter").value(6.0))
                .andExpect((ResultMatcher) jsonPath("$[0].withoutWheelMountingBolts").value(false))
                .andExpect((ResultMatcher) jsonPath("$[0]. withoutWheelHub").value(true))

                .andExpect((ResultMatcher) jsonPath("$[1].id").value(2L))
                .andExpect((ResultMatcher) jsonPath("$[1].partName").value("Brake Part2"))
                .andExpect((ResultMatcher) jsonPath("$[1].partNumber").value("789012"))
                .andExpect((ResultMatcher) jsonPath("$[1].price").value(14.99))
                .andExpect((ResultMatcher) jsonPath("$[1].amountOfParts").value(2))
                .andExpect((ResultMatcher) jsonPath("$[1].outerDiameter").value(11.0))
                .andExpect((ResultMatcher) jsonPath("$[1].centerDiameter").value(6.0))
                .andExpect((ResultMatcher)jsonPath("$[1].boreTypeNumberOfHoles").value( "Type B, 5 holes"))
                .andExpect((ResultMatcher)jsonPath("$[1].wheelStudDiameter").value(6.5))
                .andExpect((ResultMatcher)jsonPath("$[1].withoutWheelMountingBolts").value(true))
                .andExpect((ResultMatcher)jsonPath("$[1]. withoutWheelHub").value(false))

                .andExpect((ResultMatcher)jsonPath("$[2].id").value(3L))
                .andExpect((ResultMatcher)jsonPath("$[2].partName").value("Brake Part 3"))
                .andExpect((ResultMatcher)jsonPath("$[2].partNumber").value("345678"))
                .andExpect((ResultMatcher)jsonPath("$[2].price").value(19.99))
                .andExpect((ResultMatcher)jsonPath("$[2].amountOfParts").value(1))
                .andExpect((ResultMatcher)jsonPath("$[2].outerDiameter").value(10.0))
                .andExpect((ResultMatcher)jsonPath("$[2].centerDiameter").value(5.0))
                .andExpect((ResultMatcher)jsonPath("$[2].boreTypeNumberOfHoles").value("Type C, 6 holes"))
                .andExpect((ResultMatcher)jsonPath("$[2].wheelStudDiameter").value(6.2))
                .andExpect((ResultMatcher)jsonPath("$[2].withoutWheelMountingBolts").value(false))
                .andExpect((ResultMatcher)jsonPath("$[2]. withoutWheelHub").value(true));
    }



    @Test
    void getBrakeById() throws Exception {
        given(brakeService.getBrakeById(1L)).willReturn(brakesOutputDto1);

        mockMvc.perform(get("/find/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("id").value(1));
    }

    @Test
    void updateAmountOfParts() {
    }

    @Test
    void updatePrice() {
    }

    @Test
    void updatePartNumber() {
    }

    @Test
    void deleteBrakeById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/delete/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    void deleteAllBrakes() {
    }

    /*  public static String asJsonString(final Object obj) {
          try {
              ObjectMapper objectMapper = new ObjectMapper();
              SimpleModule module = new SimpleModule();
              module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_DATE));
              objectMapper.registerModule(module);
              return new ObjectMapper().writeValueAsString(obj);
          } catch (JsonProcessingException e) {
              throw new RuntimeException(e);
          }

      }
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
