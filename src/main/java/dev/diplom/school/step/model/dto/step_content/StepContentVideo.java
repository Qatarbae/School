package dev.diplom.school.step.model.dto.step_content;

import dev.diplom.school.step.model.Content;


public record StepContentVideo(
        Long id,
        Long stepId,
        String url
) implements Content {

}
