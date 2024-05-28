package dev.diplom.school.step.model.dto.step_content;

import dev.diplom.school.step.model.StepType;
import jakarta.validation.constraints.NotBlank;

public record StepContentVideoDto(
        @NotBlank
        Long lessonId,
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        StepType stepType,
        @NotBlank
        Integer position,
        @NotBlank
        StepContentVideo content
) {
}
