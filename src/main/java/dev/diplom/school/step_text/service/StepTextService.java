package dev.diplom.school.step_text.service;

import dev.diplom.school.step_text.repository.StepTextRepository;
import org.springframework.stereotype.Service;

@Service
public class StepTextService {

    private final StepTextRepository stepTextRepository;

    public StepTextService(StepTextRepository stepTextRepository) {
        this.stepTextRepository = stepTextRepository;
    }
}
