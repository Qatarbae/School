package dev.diplom.school.step_text.model.dto;

import java.util.List;

public record StepTextDeleteListDto(
        Long stepId,
        List<StepTextDeleteDto> stepTextDeleteDtoList
) {
}
