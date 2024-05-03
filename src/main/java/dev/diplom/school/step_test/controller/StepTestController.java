package dev.diplom.school.step_test.controller;

import dev.diplom.school.step_test.service.StepTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/step/step-test")
public class StepTestController {

    private final StepTestService stepTestService;

    public StepTestController(StepTestService stepTestService) {
        this.stepTestService = stepTestService;
    }
}
