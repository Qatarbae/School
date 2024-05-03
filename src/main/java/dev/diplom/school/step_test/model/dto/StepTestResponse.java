package dev.diplom.school.step_test.model.dto;

public record StepTestResponse(
        Long id,
        Long stepId,
        String name,
        Integer position
) {
}
