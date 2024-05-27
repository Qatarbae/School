package dev.diplom.school.step_text.model.dto;

public record StepTextDto(
        Long id,
        Long stepId,
        String name,
        String description,
        Integer position
) {
}
