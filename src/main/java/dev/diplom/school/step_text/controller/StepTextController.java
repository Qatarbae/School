package dev.diplom.school.step_text.controller;

import dev.diplom.school.step_text.service.StepTextService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/step/step-text")
public class StepTextController {

    private final StepTextService stepTextService;

    public StepTextController(StepTextService stepTextService) {
        this.stepTextService = stepTextService;
    }
}
