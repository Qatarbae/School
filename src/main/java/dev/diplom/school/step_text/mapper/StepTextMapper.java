package dev.diplom.school.step_text.mapper;

import dev.diplom.school.step_text.model.StepText;
import dev.diplom.school.step_text.model.dto.StepTextDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StepTextMapper {

    StepTextMapper INSTANCE = Mappers.getMapper(StepTextMapper.class);

    @Mapping(source = "stepId", target = "step.id")
    StepText toEntity(StepTextDto dto);

    @Mapping(source = "step.id", target = "stepId")
    StepTextDto toDto(StepText entity);

    List<StepText> toEntityList(List<StepTextDto> dtoList);

    List<StepTextDto> toDtoList(List<StepText> entityList);
}
