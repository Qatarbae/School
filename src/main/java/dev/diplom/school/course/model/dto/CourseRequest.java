package dev.diplom.school.course.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseRequest(
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
