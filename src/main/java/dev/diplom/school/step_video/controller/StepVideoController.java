package dev.diplom.school.step_video.controller;

import dev.diplom.school.step_video.model.dto.StepVideoDto;
import dev.diplom.school.step_video.service.StepVideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/step-video")
public class StepVideoController {

    private final StepVideoService stepVideoService;

    public StepVideoController(StepVideoService stepVideoService) {
        this.stepVideoService = stepVideoService;
    }

    @GetMapping("/find-all-step")
    public ResponseEntity<List<StepVideoDto>> getAllVideosByStepId(@RequestParam Long stepId) {
        List<StepVideoDto> stepVideos = stepVideoService.findAllStepVideoByStepId(stepId);
        return ResponseEntity.ok(stepVideos);
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<StepVideoDto> getVideoByName(@RequestParam String name) {
        StepVideoDto stepVideo = stepVideoService.findByName(name);
        return ResponseEntity.ok(stepVideo);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<StepVideoDto> getVideoById(@RequestParam Long id) {
        StepVideoDto stepVideo = stepVideoService.findById(id);
        return ResponseEntity.ok(stepVideo);
    }
}
