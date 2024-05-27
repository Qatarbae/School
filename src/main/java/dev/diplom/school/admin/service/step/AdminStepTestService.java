package dev.diplom.school.admin.service.step;

import dev.diplom.school.step.model.Step;
import dev.diplom.school.step.repository.StepRepository;
import dev.diplom.school.step_test.mapper.StepTestMapper;
import dev.diplom.school.step_test.model.StepTest;
import dev.diplom.school.step_test.model.dto.StepTestDeleteDto;
import dev.diplom.school.step_test.model.dto.StepTestDeleteListDto;
import dev.diplom.school.step_test.model.dto.StepTestDto;
import dev.diplom.school.step_test.model.dto.StepTestSaveListDto;
import dev.diplom.school.step_test.repository.StepTestRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminStepTestService {

    private final StepTestRepository stepTestRepository;

    private final StepRepository stepRepository;

    public AdminStepTestService(StepTestRepository stepTestRepository, StepRepository stepRepository) {
        this.stepTestRepository = stepTestRepository;
        this.stepRepository = stepRepository;
    }

    @Transactional
    public void deleteAllStepVTest(StepTestDeleteListDto stepTestDeleteListDto) {
        List<Long> idList = stepTestDeleteListDto.stepTestDeleteDtoList()
                .stream()
                .map(StepTestDeleteDto::id)
                .collect(Collectors.toList());
        stepTestRepository.deleteStepTestByIdListAndStepId(idList, stepTestDeleteListDto.stepId());
    }

    @Transactional
    public StepTestDto saveStepVideo(StepTestDto stepTestRequest) {
        Step step = stepRepository.findById(stepTestRequest.stepId()).orElseThrow();
        StepTest stepTest = StepTestMapper.INSTANCE.toEntity(stepTestRequest);
        stepTest.setStep(step);
        stepTest = stepTestRepository.save(stepTest);
        return StepTestMapper.INSTANCE.toDto(stepTest);
    }

    @Transactional
    public List<StepTestDto> saveAllStepTests(StepTestSaveListDto stepTestSaveListDto) {
        List<StepTest> stepTests = stepTestSaveListDto.stepTestDtoList().stream()
                .map(stepTestRequest -> {
                    Step step = stepRepository.findById(stepTestSaveListDto.stepId())
                            .orElseThrow(() -> new RuntimeException("Step not found"));

                    StepTest stepTest = StepTestMapper.INSTANCE.toEntity(stepTestRequest);
                    stepTest.setStep(step);
                    return stepTest;
                })
                .collect(Collectors.toList());
        stepTests = (List<StepTest>) stepTestRepository.saveAll(stepTests);
        return StepTestMapper.INSTANCE.toDtoList(stepTests);
    }

    @Transactional
    public void deleteStepVideo(Long stepTestId, Long stepId) {
        stepTestRepository.deleteStepTestByIdAndStepId(stepTestId, stepId);
    }
}
