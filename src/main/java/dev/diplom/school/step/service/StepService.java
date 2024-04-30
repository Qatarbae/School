package dev.diplom.school.step.service;


import dev.diplom.school.step.mapper.StepMapper;
import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.dto.StepResponse;
import dev.diplom.school.step.repository.StepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {

    private final StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }


    public StepResponse findById(Long stepId) {
        Step step = stepRepository.findById(stepId).orElseThrow();
        return StepMapper.INSTANCE.mapToStepResponse(step);
    }

    public StepResponse findByName(String name) {
        Step modules = stepRepository.findByName(name).orElseThrow();
        return StepMapper.INSTANCE.mapToStepResponse(modules);
    }

    public List<StepResponse> findAllStepByLessonId(Long lessonId) {
        List<Step> stepList = stepRepository.findAllByLesson_Id(lessonId);
        return StepMapper.INSTANCE.mapToStepResponseList(stepList);
    }
}