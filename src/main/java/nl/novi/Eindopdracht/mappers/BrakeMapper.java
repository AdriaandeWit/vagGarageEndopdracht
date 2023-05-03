package nl.novi.Eindopdracht.mappers;

import nl.novi.Eindopdracht.Models.Data.CarParts.Brakes;
import nl.novi.Eindopdracht.dto.input.CarPartsDto.BrakesDto;
import nl.novi.Eindopdracht.dto.output.BrakesOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface BrakeMapper {
BrakeMapper MAPPER = Mappers.getMapper(BrakeMapper.class);

BrakesOutputDto mapToBrakeDto(Brakes brakes);

Brakes mapToBrake(BrakesDto brakesDto);

}
