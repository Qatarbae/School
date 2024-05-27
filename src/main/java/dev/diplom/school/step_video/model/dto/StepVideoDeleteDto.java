package dev.diplom.school.step_video.model.dto;

import jakarta.validation.constraints.NotBlank;

public record StepVideoDeleteDto(
        @NotBlank
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String url,
        @NotBlank
        Integer position
) {
    @Override
    public Long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Integer position() {
        return position;
    }
}
