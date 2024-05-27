package dev.diplom.school.step_test.mapper;

import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_test.model.dto.StepTestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StepTestMapper {

    StepTestMapper INSTANCE = Mappers.getMapper(StepTestMapper.class);

    @Mapping(source = "stepId", target = "step.id")
    StepTest toEntity(StepTestDto dto);

    @Mapping(source = "step.id", target = "stepId")
    StepTestDto toDto(StepTest entity);

    List<StepTest> toEntityList(List<StepTestDto> dtoList);

    List<StepTestDto> toDtoList(List<StepTest> entityList);
}
