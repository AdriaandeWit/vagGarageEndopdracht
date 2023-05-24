package nl.novi.Eindopdracht.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import nl.novi.Eindopdracht.Controllers.BrakeController;
import nl.novi.Eindopdracht.Service.BrakeService;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.BrakesDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BrakeController.class)
class BrakeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BrakeService brakeService;

    @MockBean


    @Test
    void createBrake() {
        BrakesDto brakesDto1 = new BrakesDto();
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

        Long id = 1L;
        when(brakeService.createBrake(brakesDto1)).thenReturn(id);


        // Maak de POST-request
        mockMvc.perform(post("/car/parts/brakes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .
                        .content(asJsonString(brakesDto1)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/create/" + id))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.partName").value("Brake Part"))
                .andExpect(jsonPath("$.partNumber").value("123456"))
                .andExpect(jsonPath("$.price").value(9.99))
                .andExpect(jsonPath("$.amountOfParts").value(1))
                .andExpect(jsonPath("$.wheelStudDiameter").value(6.0));


    }

    @Test
    void getAllBrakes() {
    }

    @Test
    void getBrakeById() {
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
    void deleteBrakeById() {
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
