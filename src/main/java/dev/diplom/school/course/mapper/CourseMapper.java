package dev.diplom.school.course.mapper;


import dev.diplom.school.course.model.Course;
import dev.diplom.school.course.model.dto.CourseRequest;
import dev.diplom.school.course.model.dto.CourseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseResponse mapToCourseResponse(Course course);

    List<CourseResponse> mapToCourseResponseList(List<Course> courses);

    @Mapping(target = "id", ignore = true)
    Course mapToCourse(CourseRequest courseRequest);

    List<Course> mapToCourseList(List<CourseRequest> courseRequests);
}