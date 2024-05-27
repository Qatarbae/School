package dev.diplom.school.step_text.model.dto;

import java.util.List;

public record StepTextSaveListDto(
        Long stepId,
        List<StepTextDto> stepTextDtoList
) {
}
