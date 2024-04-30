package dev.diplom.school.lesson.controller;

import dev.diplom.school.lesson.service.LessonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/find-by-id")
    public ResponseEntity<?> getLesson(@Valid @NotBlank Long lessonId) {

        return ResponseEntity.ok().body(lessonService.findById(lessonId));
    }

    @PostMapping("/find-by-name")
    public ResponseEntity<?> getLesson(@Valid @NotBlank @RequestParam String name) {

        return ResponseEntity.ok().body(lessonService.findByName(name));
    }

    @GetMapping("/find-all-lesson")
    public ResponseEntity<?> getAllLesson(@Valid @NotBlank @RequestParam Long modulesId) {

        return ResponseEntity.ok().body(lessonService.findAllModulesByCourseId(modulesId));
    }
}
