package dev.diplom.school.step_video.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record StepVideoSaveListDto(
        @NotBlank
        Long stepId,
        @NotBlank
        List<StepVideoDto> stepVideoDtoList
) {
    @Override
    public Long stepId() {
        return stepId;
    }

    @Override
    public List<StepVideoDto> stepVideoDtoList() {
        return stepVideoDtoList;
    }
}