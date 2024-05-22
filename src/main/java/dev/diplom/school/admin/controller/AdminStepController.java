package dev.diplom.school.admin.controller;

import dev.diplom.school.admin.service.AdminStepService;
import dev.diplom.school.step.model.dto.StepDeleteListDto;
import dev.diplom.school.step.model.dto.StepRequest;
import dev.diplom.school.step.model.dto.StepResponse;
import dev.diplom.school.step.model.dto.StepSaveListDto;
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
                                      UriComponentsBuilder uriComponentsBuilder) {
        StepResponse stepResponse = adminStepService.saveStep(stepRequest);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/step/{stepId}")
                        .build(Map.of("stepId", stepResponse.id())))
                .body(stepResponse);
    }

    @PostMapping("/save-all")
    public ResponseEntity<?> saveAllStep(@RequestBody StepSaveListDto stepRequestList) {
        List<StepResponse> stepResponses = adminStepService.saveAllStep(stepRequestList);
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
    public ResponseEntity<?> deleteAllStep(@RequestBody StepDeleteListDto stepDeleteListDto) {
        adminStepService.deleteAllStep(stepDeleteListDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}