package dev.diplom.school.admin.controller;

import dev.diplom.school.result.model.dto.UserResultTestDto;
import dev.diplom.school.result.service.UserResultTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-result-test")
public class AdminUserTestResultController {

    private final UserResultTestService userResultTestService;

    public AdminUserTestResultController(UserResultTestService userResultTestService) {
        this.userResultTestService = userResultTestService;
    }

//    @GetMapping("/user")
//    public ResponseEntity<UserResultTestDto> getByUserId(@RequestParam Long userId) {
//        UserResultTestDto userResultTestDto = userResultTestService.getByUserId(userId);
//        return ResponseEntity.ok(userResultTestDto);
//    }
//
//    @GetMapping("/test")
//    public ResponseEntity<UserResultTestDto> getByStepTestId(@RequestParam Long testId) {
//        UserResultTestDto userResultTestDto = userResultTestService.getByStepTestId(testId);
//        return ResponseEntity.ok(userResultTestDto);
//    }

    @GetMapping("/user-all")
    public ResponseEntity<List<UserResultTestDto>> getAllByUserId(@RequestParam Long userId) {
        List<UserResultTestDto> userResultTestDtos = userResultTestService.getAllByUserId(userId);
        return ResponseEntity.ok(userResultTestDtos);
    }

    @GetMapping("/test-all")
    public ResponseEntity<List<UserResultTestDto>> getAllByStepTestId(@RequestParam Long testId) {
        List<UserResultTestDto> userResultTestDtos = userResultTestService.getAllByStepTestId(testId);
        return ResponseEntity.ok(userResultTestDtos);
    }

    @GetMapping("/result-type")
    public ResponseEntity<List<UserResultTestDto>> getAllByResultType(@RequestParam String resultType) {
        List<UserResultTestDto> userResultTestDtos = userResultTestService.getAllByResultType(resultType);
        return ResponseEntity.ok(userResultTestDtos);
    }

    @GetMapping("/by-user-name")
    public ResponseEntity<List<UserResultTestDto>> getResultsByUserName(@RequestParam String name) {
        return ResponseEntity.ok(userResultTestService.findAllByUserName(name));
    }

    @GetMapping("/by-test-name")
    public ResponseEntity<List<UserResultTestDto>> getResultsByTestName(@RequestParam String name) {
        return ResponseEntity.ok(userResultTestService.findAllByTestName(name));
    }
}