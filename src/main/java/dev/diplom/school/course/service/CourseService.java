package dev.diplom.school.course.service;

import dev.diplom.school.course.mapper.CourseMapper;
import dev.diplom.school.course.model.Course;
import dev.diplom.school.course.model.dto.CourseResponse;
import dev.diplom.school.course.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    public List<CourseResponse> findAllCourses() {
        List<Course> courses = (List<Course>) courseRepository.findAll();
        return CourseMapper.INSTANCE.mapToCourseResponseList(courses);
    }

    @Transactional
    public CourseResponse findByName(String name) {
        Course course = courseRepository.findByName(name).orElseThrow();
        return CourseMapper.INSTANCE.mapToCourseResponse(course);
    }

    @Transactional
    public CourseResponse findById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        return CourseMapper.INSTANCE.mapToCourseResponse(course);
    }

    @Transactional
    public List<CourseResponse> findAllByName(String name) {
        List<Course> courses = courseRepository.findAll();
        return CourseMapper.INSTANCE.mapToCourseResponseList(courses);
    }
}
