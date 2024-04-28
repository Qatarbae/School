package dev.diplom.school.admin.service;

import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminModulesService {

    private final ModulesRepository modulesRepository;

    public AdminModulesService(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }
}
