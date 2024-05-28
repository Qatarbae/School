package dev.diplom.school.step.mapper;

import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.dto.StepDto;
import dev.diplom.school.step.model.dto.StepResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StepMapper {
    StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);

    Step toEntity(StepDto request);

    StepResponse toResponse(Step step);

    List<StepResponse> toResponseList(List<Step> steps);
}
