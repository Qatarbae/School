package dev.diplom.school.admin.controller;

import dev.diplom.school.admin.service.AdminStepService;
import dev.diplom.school.step.model.dto.StepRequest;
import dev.diplom.school.step.model.dto.StepResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin/step")
public class AdminStepController {

    private final AdminStepService adminStepService;

    public AdminStepController(AdminStepService adminStepService) {
        this.adminStepService = adminStepService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveStep(@RequestBody StepRequest stepRequest,
                                      @RequestParam Long lessonId,
                                      UriComponentsBuilder uriComponentsBuilder) {
        StepResponse stepResponse = adminStepService.saveStep(stepRequest, lessonId);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/step/{stepId}")
                        .build(Map.of("stepId", stepResponse.id())))
                .body(stepResponse);
    }

    @PostMapping("/save-all")
    public ResponseEntity<?> saveAllStep(@RequestBody List<StepRequest> stepRequestList,
                                         @RequestParam Long lessonId) {
        List<StepResponse> stepResponses = adminStepService.saveAllStep(stepRequestList, lessonId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(stepResponses);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteStep(@RequestParam Long stepId, @RequestParam Long lessonId) {
        adminStepService.deleteStep(stepId, lessonId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAllStep(@RequestBody List<Long> stepIdList, @RequestParam Long lessonId) {
        adminStepService.deleteAllStep(stepIdList, lessonId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}