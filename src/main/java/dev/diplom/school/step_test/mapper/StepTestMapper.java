package dev.diplom.school.step_test.mapper;

import dev.diplom.school.step.model.dto.step_content.StepContentTest;
import dev.diplom.school.step_test.model.StepTest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StepTestMapper {

    StepTestMapper INSTANCE = Mappers.getMapper(StepTestMapper.class);

    @Mapping(target = "step.id", source = "stepId")
    @Mapping(target = "questions", ignore = true)
    StepTest toEntity(StepContentTest content);

    @Mapping(target = "stepId", source = "step.id")
    StepContentTest toResponse(StepTest stepTest);
}
