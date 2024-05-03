package dev.diplom.school.module.model.dto;

import jakarta.validation.constraints.NotBlank;

public record ModulesRequest(
        @NotBlank
        String name,
        @NotBlank
        String description
) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
}
