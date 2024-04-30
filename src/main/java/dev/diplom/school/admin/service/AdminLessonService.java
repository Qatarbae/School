package dev.diplom.school.admin.service;

import dev.diplom.school.lesson.mapper.LessonMapper;
import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.lesson.model.dto.LessonRequest;
import dev.diplom.school.lesson.model.dto.LessonResponse;
import dev.diplom.school.lesson.repository.LessonRepository;
import dev.diplom.school.module.model.Modules;
import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminLessonService {

    private final LessonRepository lessonRepository;

    private final ModulesRepository modulesRepository;

    public AdminLessonService(LessonRepository lessonRepository, ModulesRepository modulesRepository) {
        this.lessonRepository = lessonRepository;
        this.modulesRepository = modulesRepository;
    }

    @Transactional
    public void deleteAllLesson(List<Long> modulesIdList, Long modulesId) {
        lessonRepository.deleteLessonByIdListAndModulesId(modulesIdList, modulesId);
    }

    @Transactional
    public LessonResponse saveLesson(LessonRequest lessonRequest) {
        Modules modules = modulesRepository.findById(lessonRequest.modulesId()).orElseThrow();
        Lesson lesson = lessonRepository.save(LessonMapper.INSTANCE.mapToLesson(lessonRequest));
        lesson.setModules(modules);
        return LessonMapper.INSTANCE.mapToLessonResponse(lesson);
    }

    @Transactional
    public List<LessonResponse> saveAllLesson(List<LessonRequest> lessonRequestList) {
        List<Lesson> savedLesson = lessonRequestList.stream()
                .map(modulesRequest -> {
                    // Получаем объект Modules
                    Modules modules = modulesRepository.findById(modulesRequest.modulesId())
                            .orElseThrow(() -> new RuntimeException("Modules not found"));

                    // Создаем объект Lesson
                    Lesson lesson = LessonMapper.INSTANCE.mapToLesson(modulesRequest);
                    lesson.setModules(modules);

                    return lesson;
                })
                .collect(Collectors.toList());
        List<Lesson> lessonList = (List<Lesson>) lessonRepository.saveAll(savedLesson);
        return LessonMapper.INSTANCE.mapToLessonResponseList(lessonList);
    }

    @Transactional
    public void deleteLesson(Long lessonId, Long modulesId) {
        lessonRepository.deleteLessonByIdAndModulesId(lessonId, modulesId);
    }
}
