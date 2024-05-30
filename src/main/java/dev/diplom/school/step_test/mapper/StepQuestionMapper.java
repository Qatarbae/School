package dev.diplom.school.step_test.mapper;


import dev.diplom.school.step.model.dto.step_content.StepQuestionDto;
import dev.diplom.school.step_test.model.StepQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StepQuestionMapper {
    StepQuestionMapper INSTANCE = Mappers.getMapper(StepQuestionMapper.class);

    @Mapping(target = "stepTest.id", source = "stepTestId")
    @Mapping(target = "options", ignore = true)
    StepQuestion toEntity(StepQuestionDto dto);

    @Mapping(target = "stepTestId", source = "stepTest.id")
    StepQuestionDto toDto(StepQuestion entity);
}