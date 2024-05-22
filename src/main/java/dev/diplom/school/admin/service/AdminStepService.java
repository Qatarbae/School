package dev.diplom.school.admin.service;

import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.lesson.repository.LessonRepository;
import dev.diplom.school.step.mapper.StepMapper;
import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.dto.*;
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
    public void deleteAllStep(StepDeleteListDto stepDeleteListDto) {
        List<Long> idList = stepDeleteListDto.stepDeleteDtoList()
                .stream()
                .map(StepDeleteDto::id)
                .toList();
        stepRepository.deleteStepByIdListAndLessonId(idList, stepDeleteListDto.lessonId());
    }

    @Transactional
    public StepResponse saveStep(StepRequest stepRequest) {
        Lesson lesson = lessonRepository.findById(stepRequest.lessonId()).orElseThrow();
        Step step = stepRepository.save(StepMapper.INSTANCE.mapToStep(stepRequest));
        step.setLesson(lesson);
        return StepMapper.INSTANCE.mapToStepResponse(step);
    }

    @Transactional
    public List<StepResponse> saveAllStep(StepSaveListDto stepSaveListDto) {
        List<Step> savedStep = stepSaveListDto.stepRequestList().stream()
                .map(stepRequest -> {
                    // Получаем объект Lesson
                    Lesson lesson = lessonRepository.findById(stepSaveListDto.lessonId())
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