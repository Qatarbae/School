package dev.diplom.school.admin.service;

import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.lesson.repository.LessonRepository;
import dev.diplom.school.step.mapper.StepMapper;
import dev.diplom.school.step.model.Content;
import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.model.StepContentType;
import dev.diplom.school.step.model.StepType;
import dev.diplom.school.step.model.dto.*;
import dev.diplom.school.step.model.dto.step_content.StepContentText;
import dev.diplom.school.step.model.dto.step_content.StepContentVideo;
import dev.diplom.school.step.repository.StepRepository;
import dev.diplom.school.step_test.repository.StepTestRepository;
import dev.diplom.school.step_text.mapper.StepTextMapper;
import dev.diplom.school.step_text.model.StepText;
import dev.diplom.school.step_text.repository.StepTextRepository;
import dev.diplom.school.step_video.mapper.StepVideoMapper;
import dev.diplom.school.step_video.model.StepVideo;
import dev.diplom.school.step_video.repository.StepVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminStepService {

    private final StepRepository stepRepository;

    private final LessonRepository lessonRepository;

    private final StepVideoRepository stepVideoRepository;

    private final StepTextRepository stepTextRepository;

    private final StepTestRepository stepTestRepository;
    @Transactional
    public void deleteAllStep(StepDeleteListDto stepDeleteListDto) {
        List<Long> idList = stepDeleteListDto.stepDeleteDtoList()
                .stream()
                .map(StepDeleteDto::id)
                .toList();
        stepRepository.deleteStepByIdListAndLessonId(idList, stepDeleteListDto.lessonId());
    }

    @Transactional
    public StepResponse saveStep(StepDto stepRequest) {
        Lesson lesson = lessonRepository.findById(stepRequest.lessonId()).orElseThrow();
        Step step = StepMapper.INSTANCE.toEntity(stepRequest);
        step.setLesson(lesson);
        Step savedStep = stepRepository.save(step);

        StepContentType contentType = saveStepContent(stepRequest.stepType(), stepRequest.content(), step);
        switch (stepRequest.stepType()) {
            case TEXT -> savedStep.setStepText((StepText) contentType);
            case VIDEO -> savedStep.setStepVideo((StepVideo) contentType);
        }
        return mapToStepResponseWithContent(savedStep);
    }

    @Transactional
    public List<StepResponse> saveAllStep(StepSaveListDto stepSaveListDto) {
        List<Step> savedStep = stepSaveListDto.stepDtoList().stream()
                .map(stepRequest -> {
                    Lesson lesson = lessonRepository.findById(stepSaveListDto.lessonId())
                            .orElseThrow(() -> new RuntimeException("Modules not found"));

                    Step step = StepMapper.INSTANCE.toEntity(stepRequest);
                    step.setLesson(lesson);
                    step = stepRepository.save(step);

                    StepContentType contentType = saveStepContent(stepRequest.stepType(), stepRequest.content(), step);
                    switch (stepRequest.stepType()) {
                        case TEXT -> step.setStepText((StepText) contentType);
                        case VIDEO -> step.setStepVideo((StepVideo) contentType);
                    }
                    return step;
                })
                .collect(Collectors.toList());
        List<Step> stepList = (List<Step>) stepRepository.saveAll(savedStep);
        return stepList.stream()
                .map(this::mapToStepResponseWithContent)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteStep(Long stepId, Long lessonId) {
        stepRepository.deleteStepByIdAndLessonId(stepId, lessonId);
    }

    private StepContentType saveStepContent(StepType stepType, Content content, Step step) {
        StepContentType contentType = null;
        switch (stepType) {
            case TEXT:
                StepText stepText = StepTextMapper.INSTANCE.toEntity((StepContentText) content);
                stepText.setStep(step);
                contentType = stepTextRepository.save(stepText);
                break;
            case VIDEO:
                StepVideo stepVideo = StepVideoMapper.INSTANCE.toEntity((StepContentVideo) content);
                stepVideo.setStep(step);
                contentType = stepVideoRepository.save(stepVideo);
                break;
            case TEST:
                break;
            default:
                throw new IllegalArgumentException("Unknown step type");
        }
        return contentType;
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
        return switch (step.getStepType()) {
            case TEXT -> new StepContentText(step.getStepText().getId(), step.getId(), step.getStepText().getText());
            case VIDEO -> new StepContentVideo(step.getStepVideo().getId(), step.getId(), step.getStepVideo().getUrl());
            case TEST -> null;
        };
    }
}
