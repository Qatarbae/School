package dev.diplom.school.step_video.model.dto;

import jakarta.validation.constraints.NotBlank;

public record StepVideoRequest(
        @NotBlank
        String name,

        @NotBlank
        String url,

        @NotBlank
        Integer position
) {
}
