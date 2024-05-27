package dev.diplom.school.step_video.repository;

import dev.diplom.school.step_video.model.StepVideo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StepVideoRepository extends CrudRepository<StepVideo, Long> {
    List<StepVideo> findAllByStepId(Long stepId);

    Optional<StepVideo> findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM StepVideo sv WHERE sv.id IN :stepVideoIdList AND sv.step.id = :stepId")
    void deleteStepVideoByIdListAndStepId(List<Long> stepVideoIdList, Long stepId);

    @Modifying
    @Transactional
    @Query("DELETE FROM StepVideo sv WHERE sv.id = :stepVideoId AND sv.step.id = :stepId")
    void deleteStepVideoByIdAndStepId(Long stepVideoId, Long stepId);
}
