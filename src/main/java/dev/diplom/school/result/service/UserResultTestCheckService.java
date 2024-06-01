package dev.diplom.school.result.service;

import dev.diplom.school.result.model.dto.UserResultTestCheckDto;
import dev.diplom.school.result.model.dto.UserResultTestDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserResultTestCheckService {

    UserResultTestDto saveUserResultTest(UserResultTestCheckDto userResultTestDto, UserDetails userDetails);
}
