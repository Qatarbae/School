package dev.diplom.school.step.mapper;

import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.dto.StepRequest;
import dev.diplom.school.step.model.dto.StepResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StepMapper {
    StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);

    @Mapping(source = "lesson.id", target = "lessonId")
    StepResponse mapToStepResponse(Step step);

    List<StepResponse> mapToStepResponseList(List<Step> stepList);

    Step mapToStep(StepRequest lessonRequest);

    List<Step> mapToStepList(List<StepRequest> stepRequestList);
}
