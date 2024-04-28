package dev.diplom.school.course.mapper;


import dev.diplom.school.course.model.Course;
import dev.diplom.school.course.model.dto.CourseRequest;
import dev.diplom.school.course.model.dto.CourseResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseResponse mapToCourseResponse(Course course) {
        return new CourseResponse(course.getId(), course.getName(), course.getDescription());
    }

    public static List<CourseResponse> mapToCourseResponseList(List<Course> courses) {
        return courses.stream()
                .map(CourseMapper::mapToCourseResponse)
                .collect(Collectors.toList());
    }

    public static Course mapToCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setName(courseRequest.name());
        course.setDescription(courseRequest.description());
        return course;
    }

    public static List<Course> mapToCourseList(List<CourseRequest> courseRequests) {
        return courseRequests.stream()
                .map(CourseMapper::mapToCourse)
                .collect(Collectors.toList());
    }
}