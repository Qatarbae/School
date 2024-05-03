package dev.diplom.school.step_text.model.dto;

import jakarta.validation.constraints.NotBlank;

public record StepTextRequest(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        Integer position
) {
}
