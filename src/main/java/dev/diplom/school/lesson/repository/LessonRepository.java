package dev.diplom.school.lesson.repository;

import dev.diplom.school.lesson.model.Lesson;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    Optional<Lesson> findByName(String name);

    @Transactional(readOnly = true)
    @Query("SELECT l FROM Lesson l WHERE l.modules.id = :modulesId")
    List<Lesson> findAllByModules_Id(Long modulesId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Lesson l WHERE l.id IN :lessonIdList AND l.modules.id = :modulesId")
    void deleteLessonByIdListAndModulesId(List<Long> lessonIdList, Long modulesId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Lesson l WHERE l.id = :lessonId AND l.modules.id = :modulesId")
    void deleteLessonByIdAndModulesId(Long lessonId, Long modulesId);
}
