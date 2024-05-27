package dev.diplom.school.step_test.model.dto;

import java.util.List;

public record StepTestDeleteListDto(
        Long stepId,
        List<StepTestDeleteDto> stepTestDeleteDtoList
) {
}
