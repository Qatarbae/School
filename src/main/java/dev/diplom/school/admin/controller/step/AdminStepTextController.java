package dev.diplom.school.admin.controller.step;

import dev.diplom.school.admin.service.step.AdminStepTextService;
import dev.diplom.school.step_text.model.dto.StepTextDeleteListDto;
import dev.diplom.school.step_text.model.dto.StepTextDto;
import dev.diplom.school.step_text.model.dto.StepTextSaveListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/step-text")
public class AdminStepTextController {

    private final AdminStepTextService adminStepTextService;

    public AdminStepTextController(AdminStepTextService adminStepTextService) {
        this.adminStepTextService = adminStepTextService;
    }

    @PostMapping("/delete-all")
    public ResponseEntity<Void> deleteAllStepTexts(@RequestBody StepTextDeleteListDto stepTextDeleteListDto) {
        adminStepTextService.deleteAllStepVideos(stepTextDeleteListDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<StepTextDto> saveStepText(@RequestBody StepTextDto stepTextRequest) {
        StepTextDto savedStepText = adminStepTextService.saveStepVideo(stepTextRequest);
        return ResponseEntity.ok(savedStepText);
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<StepTextDto>> saveAllStepTexts(@RequestBody StepTextSaveListDto stepTextSaveListDto) {
        List<StepTextDto> savedStepTexts = adminStepTextService.saveAllStepVideos(stepTextSaveListDto);
        return ResponseEntity.ok(savedStepTexts);
    }

    @DeleteMapping("/{stepTextId}/{stepId}")
    public ResponseEntity<Void> deleteStepText(@PathVariable Long stepTextId, @PathVariable Long stepId) {
        adminStepTextService.deleteStepVideo(stepTextId, stepId);
        return ResponseEntity.noContent().build();
    }
}
