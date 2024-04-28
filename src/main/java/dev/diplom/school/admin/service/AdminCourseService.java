package dev.diplom.school.admin.service;

import dev.diplom.school.course.mapper.CourseMapper;
import dev.diplom.school.course.model.Course;
import dev.diplom.school.course.model.dto.CourseRequest;
import dev.diplom.school.course.model.dto.CourseResponse;
import dev.diplom.school.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminCourseService {

    private final CourseRepository courseRepository;

    public AdminCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course course = courseRepository.save(CourseMapper.mapToCourse(courseRequest));
        return CourseMapper.mapToCourseResponse(course);
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
