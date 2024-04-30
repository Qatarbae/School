package dev.diplom.school.step.controller;


import dev.diplom.school.step.service.StepService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/step")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @PostMapping("/find-by-id")
    public ResponseEntity<?> getStep(@Valid @NotBlank Long stepId) {

        return ResponseEntity.ok().body(stepService.findById(stepId));
    }

    @PostMapping("/find-by-name")
    public ResponseEntity<?> getStep(@Valid @NotBlank @RequestParam String name) {

        return ResponseEntity.ok().body(stepService.findByName(name));
    }

    @GetMapping("/find-all-step")
    public ResponseEntity<?> getAllStep(@Valid @NotBlank @RequestParam Long lessonId) {

        return ResponseEntity.ok().body(stepService.findAllStepByLessonId(lessonId));
    }
}