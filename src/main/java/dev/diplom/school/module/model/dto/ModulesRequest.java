package dev.diplom.school.module.model.dto;

import dev.diplom.school.course.model.Course;
import jakarta.validation.constraints.NotBlank;

public record ModulesRequest(
        @NotBlank
        Course course,
        @NotBlank
        String name,
        @NotBlank
        String description
) {
    @Override
    public Course course() {
        return course;
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
