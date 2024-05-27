package dev.diplom.school.step_text.model.dto;

import jakarta.validation.constraints.NotBlank;

public record StepTextDeleteDto(
        @NotBlank
        Long id,
        @NotBlank
        Long stepId,
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        Integer position
) {
}
