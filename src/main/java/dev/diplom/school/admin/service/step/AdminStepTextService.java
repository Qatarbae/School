package dev.diplom.school.admin.service.step;

import dev.diplom.school.step.repository.StepRepository;
import dev.diplom.school.step_text.repository.StepTextRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminStepTextService {

    private final StepTextRepository stepTextRepository;
    private final StepRepository stepRepository;

    public AdminStepTextService(StepTextRepository stepTextRepository,
                                StepRepository stepRepository) {
        this.stepTextRepository = stepTextRepository;
        this.stepRepository = stepRepository;
    }

//    @Transactional
//    public void deleteAllStepVideos(StepTextDeleteListDto stepTextDeleteListDto) {
//        List<Long> idList = stepTextDeleteListDto.stepTextDeleteDtoList()
//                .stream()
//                .map(StepTextDeleteDto::id)
//                .collect(Collectors.toList());
//        stepTextRepository.deleteStepTextByIdListAndStepId(idList, stepTextDeleteListDto.stepId());
//    }
//
//    @Transactional
//    public StepTextDto saveStepVideo(StepTextDto stepVideoRequest) {
//        Step step = stepRepository.findById(stepVideoRequest.stepId()).orElseThrow();
//        StepText stepText = StepTextMapper.INSTANCE.toEntity(stepVideoRequest);
//        stepText.setStep(step);
//        stepText = stepTextRepository.save(stepText);
//        return StepTextMapper.INSTANCE.toEntity(stepText);
//    }
//
//    @Transactional
//    public List<StepTextDto> saveAllStepVideos(StepTextSaveListDto stepTextSaveListDto) {
//        List<StepText> stepTexts = stepTextSaveListDto.stepTextDtoList().stream()
//                .map(stepTextRequest -> {
//                    Step step = stepRepository.findById(stepTextSaveListDto.stepId())
//                            .orElseThrow(() -> new RuntimeException("Step not found"));
//
//                    StepText stepText = StepTextMapper.INSTANCE.toEntity(stepTextRequest);
//                    stepText.setStep(step);
//                    return stepText;
//                })
//                .collect(Collectors.toList());
//        stepTexts = (List<StepText>) stepTextRepository.saveAll(stepTexts);
//        return StepTextMapper.INSTANCE.toEntity(stepTexts);
//    }
//
//    @Transactional
//    public void deleteStepVideo(Long stepTextId, Long stepId) {
//        stepTextRepository.deleteStepTextByIdAndStepId(stepTextId, stepId);
//    }
}
