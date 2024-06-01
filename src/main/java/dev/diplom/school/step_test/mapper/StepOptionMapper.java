package dev.diplom.school.step_test.mapper;

import dev.diplom.school.step.model.dto.step_content.StepOptionDto;
import dev.diplom.school.step_test.model.StepOption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StepOptionMapper {
    StepOptionMapper INSTANCE = Mappers.getMapper(StepOptionMapper.class);

    @Mapping(target = "stepQuestion.id", source = "stepQuestionId")
    StepOption toEntity(StepOptionDto dto);

    @Mapping(target = "stepQuestionId", source = "stepQuestion.id")
    @Mapping(target = "valid", ignore = true)
        // Игнорируем поле valid
    StepOptionDto toDto(StepOption entity);
}
