package dev.diplom.school.step_video.service;

import dev.diplom.school.step_video.exception.StepVideoException;
import dev.diplom.school.step_video.mapper.StepVideoMapper;
import dev.diplom.school.step_video.model.StepVideo;
import dev.diplom.school.step_video.model.dto.StepVideoDto;
import dev.diplom.school.step_video.repository.StepVideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StepVideoService {

    private final StepVideoRepository stepVideoRepository;

    public StepVideoService(StepVideoRepository stepVideoRepository) {
        this.stepVideoRepository = stepVideoRepository;
    }

    @Transactional(readOnly = true)
    public List<StepVideoDto> findAllStepVideoByStepId(Long stepId) {
        List<StepVideo> stepVideos = stepVideoRepository.findAllByStepId(stepId);
        return StepVideoMapper.INSTANCE.toDtoList(stepVideos);
    }

    @Transactional(readOnly = true)
    public StepVideoDto findByName(String name) {
        StepVideo stepVideo = stepVideoRepository.findByName(name)
                .orElseThrow(() -> new StepVideoException("StepVideo with name " + name + " not found"));
        return StepVideoMapper.INSTANCE.toDto(stepVideo);
    }

    @Transactional(readOnly = true)
    public StepVideoDto findById(Long stepVideoId) {
        StepVideo stepVideo = stepVideoRepository.findById(stepVideoId)
                .orElseThrow(() -> new StepVideoException("StepVideo with ID " + stepVideoId + " not found"));
        return StepVideoMapper.INSTANCE.toDto(stepVideo);
    }
}
