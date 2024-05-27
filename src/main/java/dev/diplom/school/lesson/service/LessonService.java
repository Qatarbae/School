package dev.diplom.school.lesson.service;

import dev.diplom.school.lesson.mapper.LessonMapper;
import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.lesson.model.dto.LessonResponse;
import dev.diplom.school.lesson.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public LessonResponse findById(Long modulesId) {
        Lesson lesson = lessonRepository.findById(modulesId).orElseThrow();
        return LessonMapper.INSTANCE.mapToLessonResponse(lesson);
    }

    public LessonResponse findByName(String name) {
        Lesson lesson = lessonRepository.findByName(name).orElseThrow();
        return LessonMapper.INSTANCE.mapToLessonResponse(lesson);
    }

    public List<LessonResponse> findAllLessonByModulesId(Long modulesId) {
        List<Lesson> lessonList = lessonRepository.findAllByModules_Id(modulesId);
        return LessonMapper.INSTANCE.mapToLessonResponseList(lessonList);
    }
}
