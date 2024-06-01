package dev.diplom.school.step.controller;


import dev.diplom.school.step.service.StepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/step")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getStep(@RequestParam Long stepId) {

        return ResponseEntity.ok().body(stepService.findById(stepId));
    }

    @PostMapping("/find-by-name")
    public ResponseEntity<?> getStep(@RequestParam String name) {

        return ResponseEntity.ok().body(stepService.findByName(name));
    }

    @GetMapping("/find-all-step-lesson")
    public ResponseEntity<?> getAllStepByLessonId(@RequestParam Long lessonId) {

        return ResponseEntity.ok().body(stepService.findAllStepByLessonId(lessonId));
    }

    @GetMapping("/find-all-step-modules")
    public ResponseEntity<?> getAllStepByModulesId(@RequestParam Long modulesId) {

        return ResponseEntity.ok().body(stepService.findAllStepsByModuleId(modulesId));
    }
}