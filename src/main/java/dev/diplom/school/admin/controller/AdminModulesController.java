package dev.diplom.school.admin.controller;

import dev.diplom.school.admin.service.AdminModulesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin/modules")
public class AdminModulesController {

    private final AdminModulesService adminModulesService;

    public AdminModulesController(AdminModulesService adminModulesService) {
        this.adminModulesService = adminModulesService;
    }
}
