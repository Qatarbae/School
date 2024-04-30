package dev.diplom.school.lesson.model.dto;

public record LessonResponse(
        Long id,
        Long courseId,
        String name,
        String description,
        boolean isExam
) {
}
