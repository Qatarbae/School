package dev.diplom.school.admin.controller.step;

import dev.diplom.school.admin.service.step.AdminStepTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/step-test")
public class AdminStepTestController {

    private final AdminStepTestService adminStepTestService;

    public AdminStepTestController(AdminStepTestService adminStepTestService) {
        this.adminStepTestService = adminStepTestService;
    }

//    @PostMapping("/delete-all")
//    public ResponseEntity<Void> deleteAllStepTests(@RequestBody StepTestDeleteListDto stepTestDeleteListDto) {
//        adminStepTestService.deleteAllStepVTest(stepTestDeleteListDto);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<StepTestDto> saveStepTest(@RequestBody StepTestDto stepTestRequest) {
//        StepTestDto savedStepTest = adminStepTestService.saveStepVideo(stepTestRequest);
//        return ResponseEntity.ok(savedStepTest);
//    }
//
//    @PostMapping("/save-all")
//    public ResponseEntity<List<StepTestDto>> saveAllStepTests(@RequestBody StepTestSaveListDto stepTestSaveListDto) {
//        List<StepTestDto> savedStepTests = adminStepTestService.saveAllStepTests(stepTestSaveListDto);
//        return ResponseEntity.ok(savedStepTests);
//    }
//
//    @DeleteMapping("/")
//    public ResponseEntity<Void> deleteStepTest(@RequestParam Long stepTestId, @RequestParam Long stepId) {
//        adminStepTestService.deleteStepVideo(stepTestId, stepId);
//        return ResponseEntity.noContent().build();
//    }
}