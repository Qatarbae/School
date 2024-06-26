package dev.diplom.school.admin.controller;

import dev.diplom.school.admin.service.AdminModulesService;
import dev.diplom.school.module.model.dto.ModulesDeleteListDto;
import dev.diplom.school.module.model.dto.ModulesRequest;
import dev.diplom.school.module.model.dto.ModulesRequestList;
import dev.diplom.school.module.model.dto.ModulesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/admin/modules")
public class AdminModulesController {

    private final AdminModulesService adminModulesService;

    public AdminModulesController(AdminModulesService adminModulesService) {
        this.adminModulesService = adminModulesService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveModules(@RequestBody ModulesRequest modulesRequest,
                                         UriComponentsBuilder uriComponentsBuilder) {
        ModulesResponse modulesResponse = adminModulesService.saveModules(modulesRequest);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/modules/{modulesId}")
                        .build(Map.of("modulesId", modulesResponse.id())))
                .body(modulesResponse);
    }

    @PostMapping("/save-all")
    public ResponseEntity<?> saveAllModules(@RequestBody ModulesRequestList modulesRequestList) {
        List<ModulesResponse> modulesResponses = adminModulesService.saveAllModules(modulesRequestList);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(modulesResponses);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteModules(@RequestParam Long modulesId, @RequestParam Long courseId) {
        adminModulesService.deleteModules(modulesId, courseId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<?> deleteAllModules(@RequestBody ModulesDeleteListDto modulesDeleteListDto) {
        adminModulesService.deleteAllModules(modulesDeleteListDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
