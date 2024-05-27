package dev.diplom.school.admin.controller.step;

import dev.diplom.school.admin.service.step.AdminStepVideoService;
import dev.diplom.school.step_video.model.dto.StepVideoDeleteListDto;
import dev.diplom.school.step_video.model.dto.StepVideoDto;
import dev.diplom.school.step_video.model.dto.StepVideoSaveListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/stepvideo")
public class AdminStepVideoController {

    private final AdminStepVideoService adminStepVideoService;

    public AdminStepVideoController(AdminStepVideoService adminStepVideoService) {
        this.adminStepVideoService = adminStepVideoService;
    }

    @PostMapping("/delete-all")
    public ResponseEntity<Void> deleteAllStepVideos(@RequestBody StepVideoDeleteListDto stepVideoDeleteListDto) {
        adminStepVideoService.deleteAllStepVideos(stepVideoDeleteListDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<StepVideoDto> saveStepVideo(@RequestBody StepVideoDto stepVideoRequest) {
        StepVideoDto savedStepVideo = adminStepVideoService.saveStepVideo(stepVideoRequest);
        return ResponseEntity.ok(savedStepVideo);
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<StepVideoDto>> saveAllStepVideos(@RequestBody StepVideoSaveListDto stepVideoSaveListDto) {
        List<StepVideoDto> savedStepVideos = adminStepVideoService.saveAllStepVideos(stepVideoSaveListDto);
        return ResponseEntity.ok(savedStepVideos);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteStepVideo(@RequestParam Long stepVideoId, @RequestParam Long stepId) {
        adminStepVideoService.deleteStepVideo(stepVideoId, stepId);
        return ResponseEntity.noContent().build();
    }
}
