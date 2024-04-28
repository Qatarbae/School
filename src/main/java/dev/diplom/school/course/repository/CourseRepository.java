package dev.diplom.school.course.repository;

import dev.diplom.school.course.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findByName(String name);

    List<Course> findAllByName(String name);

    void deleteById(Long id);
}
