package dev.diplom.school.module.service;

import dev.diplom.school.module.mapper.ModulesMapper;
import dev.diplom.school.module.model.Modules;
import dev.diplom.school.module.model.dto.ModulesResponse;
import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesService {

    private final ModulesRepository moduleRepository;

    public ModulesService(ModulesRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }


    public ModulesResponse findById(Long modulesId) {
        Modules modules = moduleRepository.findById(modulesId).orElseThrow();
        return ModulesMapper.INSTANCE.mapToModulesResponse(modules);
    }

    public ModulesResponse findByName(String name) {
        Modules modules = moduleRepository.findByName(name).orElseThrow();
        return ModulesMapper.INSTANCE.mapToModulesResponse(modules);
    }

    public List<ModulesResponse> findAllModulesByCourseId(Long courseId) {
        List<Modules> modulesList = moduleRepository.findAllByCourse_Id(courseId);
        return ModulesMapper.INSTANCE.mapToModulesResponseList(modulesList);
    }
}
