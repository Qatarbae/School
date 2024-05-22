package dev.diplom.school.lesson.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record LessonDeleteListDto(
        @NotBlank
        Long modulesId,
        @NotBlank
        List<LessonDeleteDto> lessonDeleteDtoList
) {
}
