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
import dev.diplom.school.step.model.dto.StepRequest;
import dev.diplom.school.step.model.dto.StepSaveListDto;
import dev.diplom.school.step_video.model.dto.StepVideoDto;
import dev.diplom.school.step_video.model.dto.StepVideoSaveListDto;
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
                    "description #" + i
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
                        add(new StepRequest(lessonId, "Step Name #" + 1, "Description #" + 1));
                        add(new StepRequest(lessonId, "Step Name #" + 2, "Description #" + 2));
                        add(new StepRequest(lessonId, "Step Name #" + 3, "Description #" + 3));
                        add(new StepRequest(lessonId, "Step Name #" + 4, "Description #" + 4));
                        add(new StepRequest(lessonId, "Step Name #" + 5, "Description #" + 5));
                    }}
            ));
        }
    }

    @Bean
    @DependsOn("initStep")
    public void initStepVideo() {
        for (Long i = 1L; i <= 5L; i++) {
            Long stepId = i;
            stepVideoService.saveAllStepVideos(new StepVideoSaveListDto(
                    stepId,
                    new ArrayList<>() {{
                        add(new StepVideoDto(0L, stepId, "Video Name #" + 1, "https://www.youtube.com/watch?v=LXb3EKWsInQ&pp=ygULdGVzdCB2aWRlbyA%3D", 1));
                        add(new StepVideoDto(0L, stepId, "Video Name #" + 2, "https://www.youtube.com/watch?v=LXb3EKWsInQ&pp=ygULdGVzdCB2aWRlbyA%3D", 2));
                    }}
            ));
        }
    }

}
