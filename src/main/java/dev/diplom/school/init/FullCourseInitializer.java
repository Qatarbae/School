package dev.diplom.school.init;

import dev.diplom.school.admin.service.AdminCourseService;
import dev.diplom.school.admin.service.AdminLessonService;
import dev.diplom.school.admin.service.AdminModulesService;
import dev.diplom.school.admin.service.AdminStepService;
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


    public FullCourseInitializer(AdminCourseService courseService, AdminModulesService modulesService, AdminLessonService lessonService, AdminStepService stepService, RestTemplate restTemplate) {
        this.courseService = courseService;
        this.modulesService = modulesService;
        this.lessonService = lessonService;
        this.stepService = stepService;
        this.restTemplate = restTemplate;

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
                        "БАЗОВЫЙ КУРС VIP #" + i,
                        "Самый наполненный курс для уверенного старта в профессии! #" + i,
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
                        add(new ModulesRequest(courseId, "Вводная информация #" + 1, "Знакомство с курсом #" + 1));
                        add(new ModulesRequest(courseId, "Оформление бровей #" + 2, "Первая теория по бровям! #" + 2));
                        add(new ModulesRequest(courseId, "Оформление бровей #" + 3, "Вторая практика по бровям! #" + 3));
                        add(new ModulesRequest(courseId, "Оформление бровей #" + 4, "Третья практика по бровям! #" + 4));
                        add(new ModulesRequest(courseId, "Оформление бровей #" + 5, "Четвертая практика по бровям! #" + 5));
                    }}
            ));
        }
    }

    @Bean
    @DependsOn("initModules")
    public void initLesson() {
        for (Long i = 1L; i <= 15L; i++) {
            Long modulesId = i;
            lessonService.saveAllLesson(new LessonSaveListDto(
                    i,
                    new ArrayList<>() {{
                        add(new LessonRequest(modulesId, "Коррекция #" + 1, "Описание Коррекция #" + 1, false));
                        add(new LessonRequest(modulesId, "Коррекция #" + 2, "Описание Коррекция #" + 2, false));
                        add(new LessonRequest(modulesId, "Окрашивание #" + 3, "Описание Окрашивание #" + 3, false));
                        add(new LessonRequest(modulesId, "Окрашивание #" + 4, "Описание Окрашивание #" + 4, false));
                        add(new LessonRequest(modulesId, "Экзамен #" + 5, "Описание Экзамен #" + 5, true));
                    }}
            ));
        }
    }

    @Bean
    @DependsOn("initLesson")
    public void initStep() {
        for (Long i = 1L; i <= 75L; i++) {
            Long lessonId = i;
            stepService.saveAllStep(new StepSaveListDto(
                    lessonId,
                    new ArrayList<>() {{
                        add(new StepDto(
                                lessonId,
                                "Материалы #" + 1,
                                "Краткое описание #" + 1,
                                StepType.TEXT,
                                1,
                                new StepContentText(
                                        null,
                                        null,
                                        "Коррекция бровей — это процедура создания правильной формы с учетом особенностей лица человека. Дома не получится сделать микроблейдинг, но можно ограничиться более простыми и менее болезненными методами обработки этой важной детали образа.\n" +
                                                "Интерес к оформлению изгиба снова вырос, но ярко выраженные брови уже не в моде. Тренды на их отсутствие или монобровь некоторое время дразнили нас своей экстравагантностью. Но в 2022 году коррекция бровей сводится к натуральности и естественности. Важно учитывать, какие линии даны тебе от природы, тип лица, макияж, одежду и даже твое настроение. Лучше придерживаться техники, которая позволяет одновременно придать форму и добавить густоты и объёма, зализанные волоски подходят не всем.\n" +
                                                "\n" +
                                                "В домашних условиях доступна коррекция формы бровей тремя разными способами. Самый популярный вариант среде них — выщипывание. Но мы расскажем еще про два метода, которые могут тебе подойти. #1"
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Материалы #" + 2,
                                "Краткое описание #" + 2,
                                StepType.TEXT,
                                2,
                                new StepContentText(
                                        null,
                                        null,
                                        "Коррекция бровей — это процедура создания правильной формы с учетом особенностей лица человека. Дома не получится сделать микроблейдинг, но можно ограничиться более простыми и менее болезненными методами обработки этой важной детали образа.\n" +
                                                "Интерес к оформлению изгиба снова вырос, но ярко выраженные брови уже не в моде. Тренды на их отсутствие или монобровь некоторое время дразнили нас своей экстравагантностью. Но в 2022 году коррекция бровей сводится к натуральности и естественности. Важно учитывать, какие линии даны тебе от природы, тип лица, макияж, одежду и даже твое настроение. Лучше придерживаться техники, которая позволяет одновременно придать форму и добавить густоты и объёма, зализанные волоски подходят не всем.\n" +
                                                "\n" +
                                                "В домашних условиях доступна коррекция формы бровей тремя разными способами. Самый популярный вариант среде них — выщипывание. Но мы расскажем еще про два метода, которые могут тебе подойти. #2"
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Методы коррекции #" + 3,
                                "Краткое описание #" + 3,
                                StepType.TEXT,
                                3,
                                new StepContentText(
                                        null,
                                        null,
                                        "Коррекция бровей — это процедура создания правильной формы с учетом особенностей лица человека. Дома не получится сделать микроблейдинг, но можно ограничиться более простыми и менее болезненными методами обработки этой важной детали образа.\n" +
                                                "Интерес к оформлению изгиба снова вырос, но ярко выраженные брови уже не в моде. Тренды на их отсутствие или монобровь некоторое время дразнили нас своей экстравагантностью. Но в 2022 году коррекция бровей сводится к натуральности и естественности. Важно учитывать, какие линии даны тебе от природы, тип лица, макияж, одежду и даже твое настроение. Лучше придерживаться техники, которая позволяет одновременно придать форму и добавить густоты и объёма, зализанные волоски подходят не всем.\n" +
                                                "\n" +
                                                "В домашних условиях доступна коррекция формы бровей тремя разными способами. Самый популярный вариант среде них — выщипывание. Но мы расскажем еще про два метода, которые могут тебе подойти. #3"
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Видео-урок #" + 4,
                                "Краткое описание #" + 4,
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
                                "Красители #" + 5,
                                "Краткое описание #" + 5,
                                StepType.TEST,
                                5,
                                new StepContentTest(
                                        null,
                                        null,
                                        "Красители #1",
                                        new HashSet<>() {{
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Сколько красителей мы разобрали на уроке?",
                                                    true,
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "3 красителя ", true));
                                                        add(new StepOptionDto(null, null, "4 красителя", false));
                                                        add(new StepOptionDto(null, null, "5 красителя", false));
                                                        add(new StepOptionDto(null, null, "6 красителя", false));
                                                    }}
                                            ));
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Сколько красителей мы разобрали на уроке?",
                                                    true,
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "3 красителя ", false));
                                                        add(new StepOptionDto(null, null, "4 красителя", true));
                                                        add(new StepOptionDto(null, null, "5 красителя", false));
                                                    }}
                                            ));
                                        }}
                                )
                        ));
                        add(new StepDto(
                                lessonId,
                                "Крема #" + 6,
                                "Краткое описание #" + 6,
                                StepType.TEST,
                                6,
                                new StepContentTest(
                                        null,
                                        null,
                                        "Крема #2",
                                        new HashSet<>() {{
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Сколько кремов мы разобрали на уроке? ",
                                                    false,
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "2", true));
                                                        add(new StepOptionDto(null, null, "3", true));
                                                        add(new StepOptionDto(null, null, "4", false));
                                                    }}
                                            ));
                                            add(new StepQuestionDto(
                                                    null, null,
                                                    "Сколько кремов мы разобрали на уроке?",
                                                    false,
                                                    new HashSet<>() {{
                                                        add(new StepOptionDto(null, null, "2", false));
                                                        add(new StepOptionDto(null, null, "3", true));
                                                        add(new StepOptionDto(null, null, "4", false));
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
