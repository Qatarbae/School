package dev.diplom.school.step_video.service;

import dev.diplom.school.step_video.repository.StepVideoRepository;
import org.springframework.stereotype.Service;

@Service
public class StepVideoService {

    private final StepVideoRepository stepVideoRepository;

    public StepVideoService(StepVideoRepository stepVideoRepository) {
        this.stepVideoRepository = stepVideoRepository;
    }
}
