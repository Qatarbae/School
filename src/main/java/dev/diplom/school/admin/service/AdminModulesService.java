package dev.diplom.school.admin.service;

import dev.diplom.school.module.mapper.ModulesMapper;
import dev.diplom.school.module.model.Modules;
import dev.diplom.school.module.model.dto.ModulesRequest;
import dev.diplom.school.module.model.dto.ModulesResponse;
import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminModulesService {

    private final ModulesRepository modulesRepository;

    public AdminModulesService(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }

    @Transactional
    public void deleteAllModules(List<Long> modulesIdList, Long courseId) {
        modulesRepository.deleteModulesByIdListAndCourseId(modulesIdList, courseId);
    }

    @Transactional
    public ModulesResponse saveModules(ModulesRequest modulesRequest) {
        Modules modules = modulesRepository.save(ModulesMapper.INSTANCE.mapToModules(modulesRequest));
        return ModulesMapper.INSTANCE.mapToModulesResponse(modules);
    }

    @Transactional
    public List<ModulesResponse> saveAllModules(List<ModulesRequest> modulesRequestList) {
        List<Modules> modules = (List<Modules>) modulesRepository.saveAll(ModulesMapper.INSTANCE.mapToModulesList(modulesRequestList));
        return ModulesMapper.INSTANCE.mapToModulesResponseList(modules);
    }

    public void deleteModules(Long modulesId, Long courseId) {
        modulesRepository.deleteModuleByIdAndCourseId(modulesId, courseId);
    }
}
