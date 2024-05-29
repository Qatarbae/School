package dev.diplom.school.course.model.dto;

public record CourseResponse(
        Long id,
        String name,
        String description,
        String image
) {
}
