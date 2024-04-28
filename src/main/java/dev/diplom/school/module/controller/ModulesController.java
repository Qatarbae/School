package dev.diplom.school.module.controller;

import dev.diplom.school.module.repository.ModulesRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/modules/")
public class ModulesController {

    private final ModulesRepository modulesRepository;

    public ModulesController(ModulesRepository modulesRepository) {
        this.modulesRepository = modulesRepository;
    }
}
