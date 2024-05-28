package dev.diplom.school.admin.controller.step;

import dev.diplom.school.admin.service.step.AdminStepVideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/step-video")
public class AdminStepVideoController {

    private final AdminStepVideoService adminStepVideoService;

    public AdminStepVideoController(AdminStepVideoService adminStepVideoService) {
        this.adminStepVideoService = adminStepVideoService;
    }
//
//    @PostMapping("/delete-all")
//    public ResponseEntity<Void> deleteAllStepVideos(@RequestBody StepVideoDeleteListDto stepVideoDeleteListDto) {
//        adminStepVideoService.deleteAllStepVideos(stepVideoDeleteListDto);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<StepVideoDto> saveStepVideo(@RequestBody StepVideoDto stepVideoRequest) {
//        StepVideoDto savedStepVideo = adminStepVideoService.saveStepVideo(stepVideoRequest);
//        return ResponseEntity.ok(savedStepVideo);
//    }
//
//    @PostMapping("/save-all")
//    public ResponseEntity<List<StepVideoDto>> saveAllStepVideos(@RequestBody StepVideoSaveListDto stepVideoSaveListDto) {
//        List<StepVideoDto> savedStepVideos = adminStepVideoService.saveAllStepVideos(stepVideoSaveListDto);
//        return ResponseEntity.ok(savedStepVideos);
//    }
//
//    @DeleteMapping("/")
//    public ResponseEntity<Void> deleteStepVideo(@RequestParam Long stepVideoId, @RequestParam Long stepId) {
//        adminStepVideoService.deleteStepVideo(stepVideoId, stepId);
//        return ResponseEntity.noContent().build();
//    }
}
