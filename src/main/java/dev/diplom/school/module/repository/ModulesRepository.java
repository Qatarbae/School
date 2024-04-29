package dev.diplom.school.module.repository;

import dev.diplom.school.module.model.Modules;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModulesRepository extends CrudRepository<Modules, Long> {

    Optional<Modules> findByName(String name);

    @Transactional(readOnly = true)
    @Query("SELECT m FROM Modules m WHERE m.course.id = :courseId")
    List<Modules> findAllByCourse_Id(Long courseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Modules m WHERE m.id IN :modulesIdList AND m.course.id = :courseId")
    void deleteModulesByIdListAndCourseId(List<Long> modulesIdList, Long courseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Modules m WHERE m.id = :moduleId AND m.course.id = :courseId")
    void deleteModuleByIdAndCourseId(Long moduleId, Long courseId);

}
