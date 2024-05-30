package dev.diplom.school.step.model.dto.step_content;

public record StepOptionDto(
        Long id, Long stepQuestionId, String option, Boolean valid
) {

}
