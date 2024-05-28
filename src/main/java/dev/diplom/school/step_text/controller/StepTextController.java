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

//    @GetMapping("/find-all-step")
//    public ResponseEntity<List<StepTextDto>> getAllVideosByStepId(@RequestParam Long stepId) {
//        List<StepTextDto> stepVideos = stepTextService.findAllStepTextByStepId(stepId);
//        return ResponseEntity.ok(stepVideos);
//    }
//
//    @GetMapping("/find-by-id")
//    public ResponseEntity<StepTextDto> getVideoById(@RequestParam Long id) {
//        StepTextDto stepVideo = stepTextService.findById(id);
//        return ResponseEntity.ok(stepVideo);
//    }
}
