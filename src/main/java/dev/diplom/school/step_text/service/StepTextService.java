package dev.diplom.school.step_text.service;

import dev.diplom.school.step_text.repository.StepTextRepository;
import org.springframework.stereotype.Service;

@Service
public class StepTextService {

    private final StepTextRepository stepTextRepository;

    public StepTextService(StepTextRepository stepTextRepository) {
        this.stepTextRepository = stepTextRepository;
    }

//    @Transactional(readOnly = true)
//    public List<StepTextDto> findAllStepTextByStepId(Long stepId) {
//        List<StepText> stepTexts = stepTextRepository.findAllByStepId(stepId);
//        return StepTextMapper.INSTANCE.toDtoList(stepTexts);
//    }
//
//    @Transactional(readOnly = true)
//    public StepTextDto findById(Long stepTextId) {
//        StepText stepText = stepTextRepository.findById(stepTextId)
//                .orElseThrow(() -> new StepTextException("StepText with ID " + stepTextId + " not found"));
//        return StepTextMapper.INSTANCE.toDto(stepText);
//    }
}
