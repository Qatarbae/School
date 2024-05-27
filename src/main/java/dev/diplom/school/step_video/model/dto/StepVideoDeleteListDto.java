package dev.diplom.school.step_video.model.dto;

import java.util.List;

public record StepVideoDeleteListDto(
        Long stepId,
        List<StepVideoDeleteDto> stepVideoDeleteDtoList
) {
}
