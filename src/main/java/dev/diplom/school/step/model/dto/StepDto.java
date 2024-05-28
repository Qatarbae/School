package dev.diplom.school.step.model.dto;


import dev.diplom.school.step.model.Content;
import dev.diplom.school.step.model.StepType;
import jakarta.validation.constraints.NotBlank;

public record StepDto(
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
        Content content
) {
}
