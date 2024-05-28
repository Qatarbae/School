package dev.diplom.school.module.controller;

import dev.diplom.school.module.exeption.ModulesException;
import dev.diplom.school.module.service.ModulesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/modules")
public class ModulesController {

    private final ModulesService modulesService;

    public ModulesController(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getModules(@RequestParam Long modulesId) {

        return ResponseEntity.ok().body(modulesService.findById(modulesId));
    }

    @GetMapping("/find-by-name")
    public ResponseEntity<?> getModules(@RequestParam String name) {

        return ResponseEntity.ok().body(modulesService.findByName(name));
    }

    @GetMapping("/find-all-modules")
    public ResponseEntity<?> getAllModules(@RequestParam Long courseId) {

        return ResponseEntity.ok().body(modulesService.findAllModulesByCourseId(courseId));
    }

    @ExceptionHandler({ModulesException.class})
    public void handleException() {

    }
}
