package dev.diplom.school.step_video.model.dto;

import dev.diplom.school.step.model.Content;

public record StepVideoDto(
        Long id,
        Long stepId,

        String name,
        String url,
        Integer position
) implements Content {
}
