package dev.diplom.school.module.service;

import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.stereotype.Service;

@Service
public class ModulesService {

    private final ModulesRepository moduleRepository;

    public ModulesService(ModulesRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }
}
