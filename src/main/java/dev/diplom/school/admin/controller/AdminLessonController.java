package dev.diplom.school.admin.controller;

import dev.diplom.school.admin.service.AdminLessonService;
import dev.diplom.school.lesson.model.dto.LessonRequest;
import dev.diplom.school.lesson.model.dto.LessonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin/lesson")
public class AdminLessonController {

    private final AdminLessonService adminLessonService;

    public AdminLessonController(AdminLessonService adminLessonService) {
        this.adminLessonService = adminLessonService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveLesson(@RequestBody LessonRequest lessonRequest,
                                        @RequestParam Long modulesId,
                                        UriComponentsBuilder uriComponentsBuilder) {
        LessonResponse lessonResponse = adminLessonService.saveLesson(lessonRequest, modulesId);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/lesson/{lessonId}")
                        .build(Map.of("lessonId", lessonResponse.id())))
                .body(lessonResponse);
    }

    @PostMapping("/save-all")
    public ResponseEntity<?> saveAllLesson(@RequestBody List<LessonRequest> lessonRequestList,
                                           @RequestParam Long modulesId) {
        List<LessonResponse> lessonResponses = adminLessonService.saveAllLesson(lessonRequestList, modulesId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lessonResponses);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteLesson(@RequestParam Long lessonId, @RequestParam Long modulesId) {
        adminLessonService.deleteLesson(lessonId, modulesId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAllLesson(@RequestBody List<Long> lessonIdList, @RequestParam Long modulesId) {
        adminLessonService.deleteAllLesson(lessonIdList, modulesId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}