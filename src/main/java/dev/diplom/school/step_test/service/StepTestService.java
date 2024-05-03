package dev.diplom.school.step_test.service;

import dev.diplom.school.step_test.repository.StepTestRepository;
import org.springframework.stereotype.Service;

@Service
public class StepTestService {

    private final StepTestRepository stepTestRepository;

    public StepTestService(StepTestRepository stepTestRepository) {
        this.stepTestRepository = stepTestRepository;
    }

}
