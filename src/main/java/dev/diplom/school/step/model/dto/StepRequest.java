package dev.diplom.school.step.model.dto;


import jakarta.validation.constraints.NotBlank;

public record StepRequest(
        @NotBlank
        Long lessonId,
        @NotBlank
        String name,
        @NotBlank
        String description
) {
    @Override
    public Long lessonId() {
        return lessonId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
}
