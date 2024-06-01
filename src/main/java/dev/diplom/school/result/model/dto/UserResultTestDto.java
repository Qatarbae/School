package dev.diplom.school.result.model.dto;

public record UserResultTestDto(
        Long id,
        String userName,
        String courseName,
        String stepTestName,
        String questionPassed,
        String resultType
) {
}
