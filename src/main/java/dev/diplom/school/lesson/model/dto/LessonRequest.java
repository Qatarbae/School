package dev.diplom.school.lesson.model.dto;

import jakarta.validation.constraints.NotBlank;

public record LessonRequest(
        @NotBlank
        Long modulesId,
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotBlank
        boolean isExam
) {
    @Override
    public Long modulesId() {
        return modulesId;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public boolean isExam() {
        return isExam;
    }
}
