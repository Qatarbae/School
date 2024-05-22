package dev.diplom.school.step.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record StepDeleteListDto(
        @NotBlank
        Long lessonId,
        @NotBlank
        List<StepDeleteDto> stepDeleteDtoList
) {
}
