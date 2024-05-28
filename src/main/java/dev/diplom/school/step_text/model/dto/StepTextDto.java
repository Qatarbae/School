package dev.diplom.school.step_text.model.dto;

import dev.diplom.school.step.model.Content;

public record StepTextDto(
        Long id,
        Long stepId,
        String name,
        String description,
        Integer position
) implements Content {
}
