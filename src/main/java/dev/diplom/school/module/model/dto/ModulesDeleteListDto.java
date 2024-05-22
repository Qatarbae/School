package dev.diplom.school.module.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ModulesDeleteListDto(
        @NotBlank
        Long courseId,
        @NotBlank
        List<ModulesDeleteDto> modulesDeleteDtoList
) {
}
