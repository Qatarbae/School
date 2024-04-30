package dev.diplom.school.step.repository;


import dev.diplom.school.step.model.Step;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StepRepository extends CrudRepository<Step, Long> {

    Optional<Step> findByName(String name);

    @Transactional(readOnly = true)
    @Query("SELECT s FROM Step s WHERE s.lesson.id = :lessonId")
    List<Step> findAllByLesson_Id(Long lessonId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Step s WHERE s.id IN :stepIdList AND s.lesson.id = :lessonId")
    void deleteStepByIdListAndLessonId(List<Long> stepIdList, Long lessonId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Step s WHERE s.id = :stepId AND s.lesson.id = :lessonId")
    void deleteStepByIdAndLessonId(Long stepId, Long lessonId);
}
