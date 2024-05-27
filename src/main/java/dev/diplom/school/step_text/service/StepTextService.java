package dev.diplom.school.step_text.service;

import dev.diplom.school.step_text.mapper.StepTextMapper;
import dev.diplom.school.step_text.model.StepText;
import dev.diplom.school.step_text.model.dto.StepTextDto;
import dev.diplom.school.step_text.repository.StepTextRepository;
import dev.diplom.school.step_video.exception.StepVideoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StepTextService {

    private final StepTextRepository stepTextRepository;

    public StepTextService(StepTextRepository stepTextRepository) {
        this.stepTextRepository = stepTextRepository;
    }

    @Transactional(readOnly = true)
    public List<StepTextDto> findAllStepTextByStepId(Long stepId) {
        List<StepText> stepTexts = stepTextRepository.findAllByStepId(stepId);
        return StepTextMapper.INSTANCE.toDtoList(stepTexts);
    }

    @Transactional(readOnly = true)
    public StepTextDto findByName(String name) {
        StepText stepText = stepTextRepository.findByName(name)
                .orElseThrow(() -> new StepVideoException("StepText with name " + name + " not found"));
        return StepTextMapper.INSTANCE.toDto(stepText);
    }

    @Transactional(readOnly = true)
    public StepTextDto findById(Long stepTextId) {
        StepText stepText = stepTextRepository.findById(stepTextId)
                .orElseThrow(() -> new StepVideoException("StepText with ID " + stepTextId + " not found"));
        return StepTextMapper.INSTANCE.toDto(stepText);
    }
}
