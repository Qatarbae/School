package dev.diplom.school.step.model.dto.step_content;

import dev.diplom.school.step.model.Content;

public record StepContentText(
        Long id,
        Long stepId,
        String text
) implements Content {
}
