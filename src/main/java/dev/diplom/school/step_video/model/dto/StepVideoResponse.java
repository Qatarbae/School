package dev.diplom.school.step_video.model.dto;

public record StepVideoResponse(
        Long id,
        Long stepId,

        String name,
        String url,
        Integer position
) {
}
