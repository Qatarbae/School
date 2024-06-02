package dev.diplom.school.result.controller;

import dev.diplom.school.result.model.dto.UserResultTestCheckDto;
import dev.diplom.school.result.service.UserResultTestCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/user-test-check")
@RequiredArgsConstructor
public class UserResultTestCheckController {

    private final UserResultTestCheckService userResultTestCheckService;

    @PostMapping
    public ResponseEntity<?> saveResultTest(@RequestBody UserResultTestCheckDto userResultTestCheckDto, Principal authentication) {
        String name = authentication.getName();

        return ResponseEntity.ok().body(userResultTestCheckService.saveUserResultTest(userResultTestCheckDto, name));
    }

}
