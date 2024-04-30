package dev.diplom.school.lesson.mapper;


import dev.diplom.school.lesson.model.Lesson;
import dev.diplom.school.lesson.model.dto.LessonRequest;
import dev.diplom.school.lesson.model.dto.LessonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(source = "modules.id", target = "modulesId")
    LessonResponse mapToLessonResponse(Lesson lesson);

    List<LessonResponse> mapToLessonResponseList(List<Lesson> lessonList);

    Lesson mapToLesson(LessonRequest lessonRequest);

    List<Lesson> mapToLessonList(List<LessonRequest> lessonRequestList);
}