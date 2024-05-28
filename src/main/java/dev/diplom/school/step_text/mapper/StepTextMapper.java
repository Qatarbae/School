package dev.diplom.school.step_text.mapper;

import dev.diplom.school.step.model.dto.step_content.StepContentText;
import dev.diplom.school.step_text.model.StepText;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StepTextMapper {

    StepTextMapper INSTANCE = Mappers.getMapper(StepTextMapper.class);

    @Mapping(target = "step.id", source = "stepId")
    StepText toEntity(StepContentText content);

    @Mapping(target = "stepId", source = "step.id")
    StepContentText toResponse(StepText stepText);
}
