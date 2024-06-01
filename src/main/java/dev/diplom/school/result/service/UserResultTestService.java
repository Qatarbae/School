package dev.diplom.school.result.service;

import dev.diplom.school.result.model.dto.UserResultTestDto;

import java.util.List;

public interface UserResultTestService {


    UserResultTestDto getByUserId(Long userId);

    UserResultTestDto getByStepTestId(Long testId);

    List<UserResultTestDto> getAllByUserId(Long userId);

    List<UserResultTestDto> getAllByStepTestId(Long testId);

    List<UserResultTestDto> getAllByResultType(String resultType);
}
