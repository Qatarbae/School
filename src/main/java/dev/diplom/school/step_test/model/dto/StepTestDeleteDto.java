package dev.diplom.school.step_test.model.dto;

public record StepTestDeleteDto(
        Long id,
        Long stepId,
        String name,
        Integer position
) {
}
