package dev.diplom.school.step_video.controller;

import dev.diplom.school.step_video.service.StepVideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/step/step-video")
public class StepVideoController {

    private final StepVideoService stepVideoService;

    public StepVideoController(StepVideoService stepVideoService) {
        this.stepVideoService = stepVideoService;
    }
}
