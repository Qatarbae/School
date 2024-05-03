package dev.diplom.school.step_test.model.dto;

import jakarta.validation.constraints.NotBlank;

public record StepTestRequest(

        @NotBlank
        String name,
        @NotBlank
        Integer position
) {
}
