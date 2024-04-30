package dev.diplom.school.step.model.dto;

public record StepResponse(
        Long id,
        Long lessonId,
        String name,
        String description
) {
}