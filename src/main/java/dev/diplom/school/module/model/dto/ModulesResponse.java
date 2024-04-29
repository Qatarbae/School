package dev.diplom.school.module.model.dto;

public record ModulesResponse(
        Long id,
        Long courseId,
        String name,
        String description
) {
}
