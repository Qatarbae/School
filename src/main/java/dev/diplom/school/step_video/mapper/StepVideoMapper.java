package dev.diplom.school.step_video.mapper;

import dev.diplom.school.step.model.dto.step_content.StepContentVideo;
import dev.diplom.school.step_video.model.StepVideo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StepVideoMapper {

    StepVideoMapper INSTANCE = Mappers.getMapper(StepVideoMapper.class);

    @Mapping(target = "step.id", source = "stepId")
    StepVideo toEntity(StepContentVideo content);

    @Mapping(target = "stepId", source = "step.id")
    StepContentVideo toResponse(StepVideo stepVideo);
}