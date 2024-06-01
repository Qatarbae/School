package dev.diplom.school.result.service;

import dev.diplom.school.result.model.dto.UserResultTestCheckDto;
import dev.diplom.school.result.model.dto.UserResultTestDto;

public interface UserResultTestCheckService {

    UserResultTestDto saveUserResultTest(UserResultTestCheckDto userResultTestDto, String name);
}
