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
import dev.diplom.school.step.model.dto.step_content.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;

@Component

public class FullCourseInitializer {

    private final AdminCourseService courseService;

    private final AdminModulesService modulesService;

    private final AdminLessonService lessonService;

    private final AdminStepService stepService;
    private final RestTemplate restTemplate;
    private final AdminStepVideoService stepVideoService;

    public FullCourseInitializer(AdminCourseService courseService, AdminModulesService modulesService, AdminLessonService lessonService, AdminStepService stepService, RestTemplate restTemplate, AdminStepVideoService stepVideoService) {
        this.courseService = courseService;
        this.modulesService = modulesService;
        this.lessonService = lessonService;
        this.stepService = stepService;
        this.restTemplate = restTemplate;
        this.stepVideoService = stepVideoService;
    }

    public String downloadImageAsBase64(String imageUrl) throws IOException {
        // Скачиваем изображение по URL и сохраняем его в массив байтов
        byte[] imageBytes = restTemplate.getForObject(imageUrl, byte[].class);

        // Определяем тип изображения (например, image/jpeg)
        String mimeType = determineMimeType(imageUrl);

        // Кодируем изображение в Base64 и добавляем префикс
        return "data:" + mimeType + ";base64," + Base64.getEncoder().encodeToString(imageBytes);
    }

    private String determineMimeType(String imageUrl) {
        // Примерный способ определения MIME типа на основе расширения файла в URL
        if (imageUrl.endsWith(".jpg") || imageUrl.endsWith(".jpeg")) {
            return "image/jpeg";
        } else if (imageUrl.endsWith(".png")) {
            return "image/png";
        } else if (imageUrl.endsWith(".gif")) {
            return "image/gif";
        } else {
            // Добавьте дополнительные проверки, если нужно
            return "application/octet-stream";
        }
    }

    @Bean
    public void initCourse() {
        for (int i = 1; i <= 3; i++) {

            try {
                courseService.createCourse(new CourseRequest(
                        "course #" + i,
                        "description #" + i,
                        downloadImageAsBase64("https://argento-nails.ru/wp-content/uploads/2021/01/20.01.2021narashhivanie-resnits.jpeg")
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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
                    lessonId,
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
                        add(new StepDto(
                                lessonId,
                                "Step name #" + 5,
                                "description #" + 5,
                                StepType.TEST,
                                5,
                                new StepContentTest(
                                        null,
                                        null,
                                        "TEST_NAME #1",
                                        new HashSet<>() {{
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Question #1",
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "Option #1", true));
                                                        add(new StepOptionDto(null, null, "Option #2", false));
                                                    }}
                                            ));
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Question #2",
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "Option #1", false));
                                                        add(new StepOptionDto(null, null, "Option #2", true));
                                                    }}
                                            ));
                                        }}
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Step name #" + 6,
                                "description #" + 6,
                                StepType.TEST,
                                6,
                                new StepContentTest(
                                        null,
                                        null,
                                        "TEST_NAME #2",
                                        new HashSet<>() {{
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Question #1",
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "Option #1", true));
                                                        add(new StepOptionDto(null, null, "Option #2", false));
                                                        add(new StepOptionDto(null, null, "Option #3", false));
                                                    }}
                                            ));
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Question #2",
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "Option #1", false));
                                                        add(new StepOptionDto(null, null, "Option #2", true));
                                                        add(new StepOptionDto(null, null, "Option #3", false));
                                                    }}
                                            ));
                                        }}
                                )
                        ));
                    }}
            ));
        }
    }
}
