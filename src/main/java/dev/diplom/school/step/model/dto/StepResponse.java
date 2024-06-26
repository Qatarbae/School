package dev.diplom.school.step.model.dto;

import dev.diplom.school.step.model.Content;
import dev.diplom.school.step.model.StepType;

public record StepResponse(
        Long id,
        Long lessonId,
        String name,
        String description,
        StepType stepType,
        Integer position,
        Content content
) {
}