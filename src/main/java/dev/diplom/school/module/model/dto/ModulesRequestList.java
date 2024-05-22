package dev.diplom.school.module.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ModulesRequestList(
        @NotBlank
        Long courseId,
        @NotBlank
        List<ModulesRequest> modulesRequests
) {
    @Override
    public Long courseId() {
        return courseId;
    }

    @Override
    public List<ModulesRequest> modulesRequests() {
        return modulesRequests;
    }
}
