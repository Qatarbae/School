package dev.diplom.school.admin.controller;

import dev.diplom.school.admin.service.AdminStepService;
import dev.diplom.school.step.model.dto.StepDeleteListDto;
import dev.diplom.school.step.model.dto.StepDto;
import dev.diplom.school.step.model.dto.StepResponse;
import dev.diplom.school.step.model.dto.step_content.StepContentTestDto;
import dev.diplom.school.step.model.dto.step_content.StepContentTextDto;
import dev.diplom.school.step.model.dto.step_content.StepContentVideoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("api/v1/admin/step")
public class AdminStepController {

    private final AdminStepService adminStepService;

    public AdminStepController(AdminStepService adminStepService) {
        this.adminStepService = adminStepService;
    }

    @PostMapping("/save-text")
    public ResponseEntity<?> saveStepText(@RequestBody StepContentTextDto stepContentDto,
                                      UriComponentsBuilder uriComponentsBuilder) {
        StepDto stepDto = new StepDto(
                stepContentDto.lessonId(),
                stepContentDto.name(),
                stepContentDto.description(),
                stepContentDto.stepType(),
                stepContentDto.position(),
                stepContentDto.content()
        );
        StepResponse stepResponse = adminStepService.saveStep(stepDto);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/step/save-text/{stepId}")
                        .build(Map.of("stepId", stepResponse.id())))
                .body(stepResponse);
    }

    @PostMapping("/save-video")
    public ResponseEntity<?> saveStepVideo(@RequestBody StepContentVideoDto stepContentDto,
                                           UriComponentsBuilder uriComponentsBuilder) {
        StepDto stepDto = new StepDto(
                stepContentDto.lessonId(),
                stepContentDto.name(),
                stepContentDto.description(),
                stepContentDto.stepType(),
                stepContentDto.position(),
                stepContentDto.content()
        );
        StepResponse stepResponse = adminStepService.saveStep(stepDto);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/step/save-video/{stepId}")
                        .build(Map.of("stepId", stepResponse.id())))
                .body(stepResponse);
    }

    @PostMapping("/save-test")
    public ResponseEntity<?> saveStepTest(@RequestBody StepContentTestDto stepContentDto,
                                          UriComponentsBuilder uriComponentsBuilder) {
        StepDto stepDto = new StepDto(
                stepContentDto.lessonId(),
                stepContentDto.name(),
                stepContentDto.description(),
                stepContentDto.stepType(),
                stepContentDto.position(),
                stepContentDto.content()
        );
        StepResponse stepResponse = adminStepService.saveStep(stepDto);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/step/save-test/{stepId}")
                        .build(Map.of("stepId", stepResponse.id())))
                .body(stepResponse);
    }

//    @PostMapping("/save-all")
//    public ResponseEntity<?> saveAllStep(@RequestBody StepSaveListDto stepRequestList) {
//        List<StepResponse> stepResponses = adminStepService.saveAllStep(stepRequestList);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(stepResponses);
//    }

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