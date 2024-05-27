package dev.diplom.school.step_test.controller;

import dev.diplom.school.step_test.model.dto.StepTestDto;
import dev.diplom.school.step_test.service.StepTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/step/step-test")
public class StepTestController {

    private final StepTestService stepTestService;

    public StepTestController(StepTestService stepTestService) {
        this.stepTestService = stepTestService;
    }

    @GetMapping("/find-all-step")
    public ResponseEntity<List<StepTestDto>> getAllVideosByStepId(@RequestParam Long stepId) {
        List<StepTestDto> stepVideos = stepTestService.findAllStepTestByStepId(stepId);
        return ResponseEntity.ok(stepVideos);
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<StepTestDto> getVideoByName(@RequestParam String name) {
        StepTestDto stepVideo = stepTestService.findByName(name);
        return ResponseEntity.ok(stepVideo);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<StepTestDto> getVideoById(@RequestParam Long id) {
        StepTestDto stepVideo = stepTestService.findById(id);
        return ResponseEntity.ok(stepVideo);
    }
}
