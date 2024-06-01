package dev.diplom.school.step.service;


import dev.diplom.school.step.model.Content;
import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.dto.StepResponse;
import dev.diplom.school.step.model.dto.step_content.StepContentTest;
import dev.diplom.school.step.model.dto.step_content.StepOptionDto;
import dev.diplom.school.step.model.dto.step_content.StepQuestionDto;
import dev.diplom.school.step.repository.StepRepository;
import dev.diplom.school.step_test.mapper.StepOptionMapper;
import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_text.mapper.StepTextMapper;
import dev.diplom.school.step_video.mapper.StepVideoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StepService {

    private final StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }


    public StepResponse findById(Long stepId) {
        Step step = stepRepository.findById(stepId).orElseThrow();
        return mapToStepResponseWithContent(step);
    }

    public StepResponse findByName(String name) {
        Step step = stepRepository.findByName(name).orElseThrow();
        return mapToStepResponseWithContent(step);
    }

    public List<StepResponse> findAllStepByLessonId(Long lessonId) {
        List<Step> stepList = stepRepository.findAllByLesson_Id(lessonId);
        return stepList.stream()
                .map(this::mapToStepResponseWithContent)
                .collect(Collectors.toList());
    }

    private StepResponse mapToStepResponseWithContent(Step step) {
        Content content = getContentForStep(step);
        return new StepResponse(
                step.getId(),
                step.getLesson().getId(),
                step.getName(),
                step.getDescription(),
                step.getStepType(),
                step.getPosition(),
                content
        );
    }

    private Content getContentForStep(Step step) {
        switch (step.getStepType()) {
            case TEXT:
                return StepTextMapper.INSTANCE.toResponse(step.getStepText());
            case VIDEO:
                return StepVideoMapper.INSTANCE.toResponse(step.getStepVideo());
            case TEST:
                StepTest stepTest = step.getStepTest();
                Set<StepQuestionDto> questionDtos = stepTest.getQuestions().stream()
                        .map(question -> {
                            Set<StepOptionDto> optionDtos = question.getOptions().stream()
                                    .map(option -> StepOptionMapper.INSTANCE.toDto(option))
                                    .collect(Collectors.toSet());
                            return new StepQuestionDto(question.getId(), stepTest.getId(), question.getQuestion(), question.isOneCorrect(), optionDtos);
                        })
                        .collect(Collectors.toSet());
                return new StepContentTest(stepTest.getId(), step.getId(), stepTest.getName(), questionDtos);
            default:
                throw new IllegalArgumentException("Unknown step type: " + step.getStepType());
        }
    }
}