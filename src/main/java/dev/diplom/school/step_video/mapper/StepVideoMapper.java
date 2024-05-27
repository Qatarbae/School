package dev.diplom.school.step_video.mapper;

import dev.diplom.school.step_video.model.StepVideo;
import dev.diplom.school.step_video.model.dto.StepVideoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StepVideoMapper {

    StepVideoMapper INSTANCE = Mappers.getMapper(StepVideoMapper.class);

    @Mapping(source = "stepId", target = "step.id")
    StepVideo toEntity(StepVideoDto dto);

    @Mapping(source = "step.id", target = "stepId")
    StepVideoDto toDto(StepVideo entity);

    List<StepVideo> toEntityList(List<StepVideoDto> dtoList);

    List<StepVideoDto> toDtoList(List<StepVideo> entityList);
}