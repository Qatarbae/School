package dev.diplom.school.admin.service;

import dev.diplom.school.course.mapper.CourseMapper;
import dev.diplom.school.course.model.Course;
import dev.diplom.school.course.model.dto.CourseRequest;
import dev.diplom.school.course.model.dto.CourseResponse;
import dev.diplom.school.course.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminCourseService {

    private final CourseRepository courseRepository;

    public AdminCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = courseRepository.save(CourseMapper.INSTANCE.mapToCourse(courseRequest));
        return CourseMapper.INSTANCE.mapToCourseResponse(course);
    }

    @Transactional
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
