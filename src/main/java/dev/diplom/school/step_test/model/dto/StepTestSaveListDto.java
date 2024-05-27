package dev.diplom.school.step_test.model.dto;

import java.util.List;

public record StepTestSaveListDto(
        Long stepId,
        List<StepTestDto> stepTestDtoList
) {
}
