package dev.diplom.school.step_text.repository;

import dev.diplom.school.step_text.model.StepText;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StepTextRepository extends CrudRepository<StepText, Long> {
    List<StepText> findAllByStepId(Long stepId);

    @Modifying
    @Transactional
    @Query("DELETE FROM StepText st WHERE st.id IN :stepTextIdList AND st.step.id = :stepId")
    void deleteStepTextByIdListAndStepId(List<Long> stepTextIdList, Long stepId);

    @Modifying
    @Transactional
    @Query("DELETE FROM StepText st WHERE st.id = :stepTextId AND st.step.id = :stepId")
    void deleteStepTextByIdAndStepId(Long stepTextId, Long stepId);
}
