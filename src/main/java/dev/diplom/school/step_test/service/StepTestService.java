package dev.diplom.school.step_test.service;

import dev.diplom.school.step_test.mapper.StepTestMapper;
import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_test.model.dto.StepTestDto;
import dev.diplom.school.step_test.repository.StepTestRepository;
import dev.diplom.school.step_text.exception.StepTextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StepTestService {

    private final StepTestRepository stepTestRepository;

    public StepTestService(StepTestRepository stepTestRepository) {
        this.stepTestRepository = stepTestRepository;
    }

    @Transactional(readOnly = true)
    public List<StepTestDto> findAllStepTestByStepId(Long stepId) {
        List<StepTest> stepTexts = stepTestRepository.findAllByStepId(stepId);
        return StepTestMapper.INSTANCE.toDtoList(stepTexts);
    }

    @Transactional(readOnly = true)
    public StepTestDto findByName(String name) {
        StepTest stepText = stepTestRepository.findByName(name)
                .orElseThrow(() -> new StepTextException("StepText with name " + name + " not found"));
        return StepTestMapper.INSTANCE.toDto(stepText);
    }

    @Transactional(readOnly = true)
    public StepTestDto findById(Long stepTextId) {
        StepTest stepText = stepTestRepository.findById(stepTextId)
                .orElseThrow(() -> new StepTextException("StepText with ID " + stepTextId + " not found"));
        return StepTestMapper.INSTANCE.toDto(stepText);
    }
}
