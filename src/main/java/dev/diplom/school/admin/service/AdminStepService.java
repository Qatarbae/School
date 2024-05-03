package dev.diplom.school.admin.service;

import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.lesson.repository.LessonRepository;
import dev.diplom.school.step.mapper.StepMapper;
import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.dto.StepRequest;
import dev.diplom.school.step.model.dto.StepResponse;
import dev.diplom.school.step.repository.StepRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminStepService {

    private final StepRepository stepRepository;

    private final LessonRepository lessonRepository;

    public AdminStepService(StepRepository stepRepository, LessonRepository lessonRepository) {
        this.stepRepository = stepRepository;
        this.lessonRepository = lessonRepository;
    }

    @Transactional
    public void deleteAllStep(List<Long> stepIdList, Long lessonId) {
        stepRepository.deleteStepByIdListAndLessonId(stepIdList, lessonId);
    }

    @Transactional
    public StepResponse saveStep(StepRequest stepRequest, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();
        Step step = stepRepository.save(StepMapper.INSTANCE.mapToStep(stepRequest));
        step.setLesson(lesson);
        return StepMapper.INSTANCE.mapToStepResponse(step);
    }

    @Transactional
    public List<StepResponse> saveAllStep(List<StepRequest> stepRequestList, Long lessonId) {
        List<Step> savedStep = stepRequestList.stream()
                .map(stepRequest -> {
                    // Получаем объект Lesson
                    Lesson lesson = lessonRepository.findById(lessonId)
                            .orElseThrow(() -> new RuntimeException("Modules not found"));

                    // Создаем объект Step
                    Step step = StepMapper.INSTANCE.mapToStep(stepRequest);
                    step.setLesson(lesson);

                    return step;
                })
                .collect(Collectors.toList());
        List<Step> stepList = (List<Step>) stepRepository.saveAll(savedStep);
        return StepMapper.INSTANCE.mapToStepResponseList(stepList);
    }

    @Transactional
    public void deleteStep(Long stepId, Long lessonId) {
        stepRepository.deleteStepByIdAndLessonId(stepId, lessonId);
    }
}