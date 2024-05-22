package dev.diplom.school.admin.service;

import dev.diplom.school.course.model.Course;
import dev.diplom.school.course.repository.CourseRepository;
import dev.diplom.school.module.mapper.ModulesMapper;
import dev.diplom.school.module.model.Modules;
import dev.diplom.school.module.model.dto.ModulesRequest;
import dev.diplom.school.module.model.dto.ModulesResponse;
import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminModulesService {

    private final ModulesRepository modulesRepository;
    private final CourseRepository courseRepository;

    public AdminModulesService(ModulesRepository modulesRepository, CourseRepository courseRepository) {
        this.modulesRepository = modulesRepository;
        this.courseRepository = courseRepository;
    }
    @Transactional
    public void deleteAllModules(List<Long> modulesIdList, Long courseId) {
        modulesRepository.deleteModulesByIdListAndCourseId(modulesIdList, courseId);
    }

    @Transactional
    public ModulesResponse saveModules(ModulesRequest modulesRequest) {
        Course course = courseRepository.findById(modulesRequest.courseId()).orElseThrow();
        Modules modules = modulesRepository.save(ModulesMapper.INSTANCE.mapToModules(modulesRequest));
        modules.setCourse(course);
        return ModulesMapper.INSTANCE.mapToModulesResponse(modules);
    }

    @Transactional
    public List<ModulesResponse> saveAllModules(List<ModulesRequest> modulesRequestList, Long courseId) {
        List<Modules> savedModules = modulesRequestList.stream()
                .map(modulesRequest -> {
                    // Получаем объект Course
                    Course course = courseRepository.findById(courseId)
                            .orElseThrow(() -> new RuntimeException("Course not found"));

                    // Создаем объект Modules
                    Modules modules = ModulesMapper.INSTANCE.mapToModules(modulesRequest);
                    modules.setCourse(course);

                    return modules;
                })
                .collect(Collectors.toList());
        List<Modules> modules = (List<Modules>) modulesRepository.saveAll(savedModules);
        return ModulesMapper.INSTANCE.mapToModulesResponseList(modules);
    }

    @Transactional
    public void deleteModules(Long modulesId, Long courseId) {
        modulesRepository.deleteModuleByIdAndCourseId(modulesId, courseId);
    }
}
