package dev.diplom.school.admin.service.step;

import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.repository.StepRepository;
import dev.diplom.school.step_text.mapper.StepTextMapper;
import dev.diplom.school.step_text.model.StepText;
import dev.diplom.school.step_text.model.dto.StepTextDeleteDto;
import dev.diplom.school.step_text.model.dto.StepTextDeleteListDto;
import dev.diplom.school.step_text.model.dto.StepTextDto;
import dev.diplom.school.step_text.model.dto.StepTextSaveListDto;
import dev.diplom.school.step_text.repository.StepTextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminStepTextService {

    private final StepTextRepository stepTextRepository;
    private final StepRepository stepRepository;

    public AdminStepTextService(StepTextRepository stepTextRepository,
                                StepRepository stepRepository) {
        this.stepTextRepository = stepTextRepository;
        this.stepRepository = stepRepository;
    }

    @Transactional
    public void deleteAllStepVideos(StepTextDeleteListDto stepTextDeleteListDto) {
        List<Long> idList = stepTextDeleteListDto.stepTextDeleteDtoList()
                .stream()
                .map(StepTextDeleteDto::id)
                .collect(Collectors.toList());
        stepTextRepository.deleteStepTextByIdListAndStepId(idList, stepTextDeleteListDto.stepId());
    }

    @Transactional
    public StepTextDto saveStepVideo(StepTextDto stepVideoRequest) {
        Step step = stepRepository.findById(stepVideoRequest.stepId()).orElseThrow();
        StepText stepText = StepTextMapper.INSTANCE.toEntity(stepVideoRequest);
        stepText.setStep(step);
        stepText = stepTextRepository.save(stepText);
        return StepTextMapper.INSTANCE.toDto(stepText);
    }

    @Transactional
    public List<StepTextDto> saveAllStepVideos(StepTextSaveListDto stepTextSaveListDto) {
        List<StepText> stepTexts = stepTextSaveListDto.stepTextDtoList().stream()
                .map(stepTextRequest -> {
                    Step step = stepRepository.findById(stepTextSaveListDto.stepId())
                            .orElseThrow(() -> new RuntimeException("Step not found"));

                    StepText stepText = StepTextMapper.INSTANCE.toEntity(stepTextRequest);
                    stepText.setStep(step);
                    return stepText;
                })
                .collect(Collectors.toList());
        stepTexts = (List<StepText>) stepTextRepository.saveAll(stepTexts);
        return StepTextMapper.INSTANCE.toDtoList(stepTexts);
    }

    @Transactional
    public void deleteStepVideo(Long stepTextId, Long stepId) {
        stepTextRepository.deleteStepTextByIdAndStepId(stepTextId, stepId);
    }
}
