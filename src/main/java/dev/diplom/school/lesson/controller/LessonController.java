package dev.diplom.school.lesson.controller;

import dev.diplom.school.lesson.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getLesson(@RequestParam Long lessonId) {

        return ResponseEntity.ok().body(lessonService.findById(lessonId));
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<?> getLesson(@RequestParam String name) {

        return ResponseEntity.ok().body(lessonService.findByName(name));
    }

    @GetMapping("/find-all-lesson")
    public ResponseEntity<?> getAllLesson(@RequestParam Long modulesId) {

        return ResponseEntity.ok().body(lessonService.findAllLessonByModulesId(modulesId));
    }
}
