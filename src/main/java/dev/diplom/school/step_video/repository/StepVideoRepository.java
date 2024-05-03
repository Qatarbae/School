package dev.diplom.school.step_video.repository;

import dev.diplom.school.step_video.model.StepVideo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepVideoRepository extends CrudRepository<StepVideo, Long> {
}
