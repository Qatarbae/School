package dev.diplom.school.module.controller;

import dev.diplom.school.module.service.ModulesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/modules")
public class ModulesController {

    private final ModulesService modulesService;

    public ModulesController(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @PostMapping("/find-by-id")
    public ResponseEntity<?> getModules(@Valid @NotBlank Long modulesId) {

        return ResponseEntity.ok().body(modulesService.findById(modulesId));
    }

    @PostMapping("/find-by-name")
    public ResponseEntity<?> getModules(@Valid @NotBlank @RequestParam String name) {

        return ResponseEntity.ok().body(modulesService.findByName(name));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllModules(@Valid @NotBlank @RequestParam Long courseId) {

        return ResponseEntity.ok().body(modulesService.findAllModulesByCourseId(courseId));
    }
}
