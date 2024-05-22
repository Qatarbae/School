package dev.diplom.school.step.model.dto;

import jakarta.validation.constraints.NotBlank;

public record StepDeleteDto(
        @NotBlank
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String description
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
    public String description() {
        return description;
    }
}
