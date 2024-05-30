package dev.diplom.school.step.model.dto.step_content;

import dev.diplom.school.step.model.Content;

import java.util.Set;

public record StepContentTest(
        Long id,
        Long stepId,
        String name,
        Set<StepQuestionDto> questions
) implements Content {
}
