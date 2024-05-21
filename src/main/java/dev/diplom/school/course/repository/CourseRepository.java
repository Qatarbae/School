package dev.diplom.school.course.repository;

import dev.diplom.school.course.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findByName(String name);

    List<Course> findAll();

    void deleteById(Long id);
}
