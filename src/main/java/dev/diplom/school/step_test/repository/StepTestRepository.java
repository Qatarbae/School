package dev.diplom.school.step_test.repository;

import dev.diplom.school.step_test.model.StepTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StepTestRepository extends CrudRepository<StepTest, Long> {

    List<StepTest> findAllByStepId(Long stepId);

    Optional<StepTest> findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM StepTest st WHERE st.id IN :stepTestIdList AND st.step.id = :stepId")
    void deleteStepTestByIdListAndStepId(List<Long> stepTestIdList, Long stepId);

    @Modifying
    @Transactional
    @Query("DELETE FROM StepTest st WHERE st.id = :stepTestId AND st.step.id = :stepId")
    void deleteStepTestByIdAndStepId(Long stepTestId, Long stepId);
}
