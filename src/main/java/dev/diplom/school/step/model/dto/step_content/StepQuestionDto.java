package dev.diplom.school.step.model.dto.step_content;

import java.util.Set;

public record StepQuestionDto(
        Long id, Long stepTestId, String question, Set<StepOptionDto> options
) {
}
