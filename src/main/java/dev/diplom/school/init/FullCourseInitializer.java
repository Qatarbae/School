package dev.diplom.school.init;

import dev.diplom.school.admin.service.AdminCourseService;
import dev.diplom.school.admin.service.AdminLessonService;
import dev.diplom.school.admin.service.AdminModulesService;
import dev.diplom.school.admin.service.AdminStepService;
import dev.diplom.school.admin.service.step.AdminStepVideoService;
import dev.diplom.school.course.model.dto.CourseRequest;
import dev.diplom.school.lesson.model.dto.LessonRequest;
import dev.diplom.school.lesson.model.dto.LessonSaveListDto;
import dev.diplom.school.module.model.dto.ModulesRequest;
import dev.diplom.school.module.model.dto.ModulesRequestList;
import dev.diplom.school.step.model.StepType;
import dev.diplom.school.step.model.dto.StepDto;
import dev.diplom.school.step.model.dto.StepSaveListDto;
import dev.diplom.school.step.model.dto.step_content.StepContentText;
import dev.diplom.school.step.model.dto.step_content.StepContentVideo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FullCourseInitializer {

    private final AdminCourseService courseService;

    private final AdminModulesService modulesService;

    private final AdminLessonService lessonService;

    private final AdminStepService stepService;

    private final AdminStepVideoService stepVideoService;

    public FullCourseInitializer(AdminCourseService courseService,
                                 AdminModulesService modulesService,
                                 AdminLessonService lessonService,
                                 AdminStepService stepService,
                                 AdminStepVideoService stepVideoService) {
        this.courseService = courseService;
        this.modulesService = modulesService;
        this.lessonService = lessonService;
        this.stepService = stepService;
        this.stepVideoService = stepVideoService;
    }

    @Bean
    public void initCourse() {
        for (int i = 1; i <= 3; i++) {
            courseService.createCourse(new CourseRequest(
                    "course #" + i,
                    "description #" + i,
                    "null"
            ));
        }
    }

    @Bean
    @DependsOn("initCourse")
    public void initModules() {
        for (Long i = 1L; i <= 3L; i++) {
            Long courseId = i;
            modulesService.saveAllModules(new ModulesRequestList(
                    i,
                    new ArrayList<>() {{
                        add(new ModulesRequest(courseId, "Modules Name #" + 1, "Description #" + 1));
                        add(new ModulesRequest(courseId, "Modules Name #" + 2, "Description #" + 2));
                        add(new ModulesRequest(courseId, "Modules Name #" + 3, "Description #" + 3));
                        add(new ModulesRequest(courseId, "Modules Name #" + 4, "Description #" + 4));
                        add(new ModulesRequest(courseId, "Modules Name #" + 5, "Description #" + 5));
                    }}
            ));
        }
    }

    @Bean
    @DependsOn("initModules")
    public void initLesson() {
        for (Long i = 1L; i <= 5L; i++) {
            Long modulesId = i;
            lessonService.saveAllLesson(new LessonSaveListDto(
                    i,
                    new ArrayList<>() {{
                        add(new LessonRequest(modulesId, "Lesson Name #" + 1, "Description #" + 1, false));
                        add(new LessonRequest(modulesId, "Lesson Name #" + 2, "Description #" + 2, false));
                        add(new LessonRequest(modulesId, "Lesson Name #" + 3, "Description #" + 3, false));
                        add(new LessonRequest(modulesId, "Lesson Name #" + 4, "Description #" + 4, true));
                        add(new LessonRequest(modulesId, "Lesson Name #" + 5, "Description #" + 5, false));
                    }}
            ));
        }
    }

    @Bean
    @DependsOn("initLesson")
    public void initStep() {
        for (Long i = 1L; i <= 5L; i++) {
            Long lessonId = i;
            stepService.saveAllStep(new StepSaveListDto(
                    i,
                    new ArrayList<>() {{
                        add(new StepDto(
                                lessonId,
                                "Step name #" + 1,
                                "description #" + 1,
                                StepType.TEXT,
                                1,
                                new StepContentText(
                                        null,
                                        null,
                                        "TEXT_TEXT_TEXT #1"
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Step name #" + 2,
                                "description #" + 2,
                                StepType.TEXT,
                                2,
                                new StepContentText(
                                        null,
                                        null,
                                        "TEXT_TEXT_TEXT #2"
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Step name #" + 3,
                                "description #" + 3,
                                StepType.TEXT,
                                3,
                                new StepContentText(
                                        null,
                                        null,
                                        "TEXT_TEXT_TEXT #3"
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Step name #" + 4,
                                "description #" + 4,
                                StepType.VIDEO,
                                4,
                                new StepContentVideo(
                                        null,
                                        null,
                                        "https://www.youtube.com/watch?v=LXb3EKWsInQ&pp=ygUKdGVzdCB2aWRlbw%3D%3D"
                                )
                        ));
                    }}
            ));
        }
    }
}
