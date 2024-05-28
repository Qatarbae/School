package dev.diplom.school.admin.service.step;

import dev.diplom.school.step.repository.StepRepository;
import dev.diplom.school.step_video.repository.StepVideoRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminStepVideoService {

    private final StepVideoRepository stepVideoRepository;
    private final StepRepository stepRepository;

    public AdminStepVideoService(StepVideoRepository stepVideoRepository, StepRepository stepRepository) {
        this.stepVideoRepository = stepVideoRepository;
        this.stepRepository = stepRepository;
    }
//
//    @Transactional
//    public void deleteAllStepVideos(StepVideoDeleteListDto stepVideoDeleteListDto) {
//        List<Long> idList = stepVideoDeleteListDto.stepVideoDeleteDtoList()
//                .stream()
//                .map(StepVideoDeleteDto::id)
//                .collect(Collectors.toList());
//        stepVideoRepository.deleteStepVideoByIdListAndStepId(idList, stepVideoDeleteListDto.stepId());
//    }
//
//    @Transactional
//    public StepVideoDto saveStepVideo(StepVideoDto stepVideoRequest) {
//        Step step = stepRepository.findById(stepVideoRequest.stepId()).orElseThrow();
//        StepVideo stepVideo = StepVideoMapper.INSTANCE.toEntity(stepVideoRequest);
//        stepVideo.setStep(step);
//        stepVideo = stepVideoRepository.save(stepVideo);
//        return StepVideoMapper.INSTANCE.toDto(stepVideo);
//    }
//
//    @Transactional
//    public List<StepVideoDto> saveAllStepVideos(StepVideoSaveListDto stepVideoSaveListDto) {
//        List<StepVideo> stepVideos = stepVideoSaveListDto.stepVideoDtoList().stream()
//                .map(stepVideoRequest -> {
//                    Step step = stepRepository.findById(stepVideoSaveListDto.stepId())
//                            .orElseThrow(() -> new RuntimeException("Step not found"));
//
//                    StepVideo stepVideo = StepVideoMapper.INSTANCE.toEntity(stepVideoRequest);
//                    stepVideo.setStep(step);
//                    return stepVideo;
//                })
//                .collect(Collectors.toList());
//        stepVideos = (List<StepVideo>) stepVideoRepository.saveAll(stepVideos);
//        return StepVideoMapper.INSTANCE.toDtoList(stepVideos);
//    }
//
//    @Transactional
//    public void deleteStepVideo(Long stepVideoId, Long stepId) {
//        stepVideoRepository.deleteStepVideoByIdAndStepId(stepVideoId, stepId);
//    }
}
