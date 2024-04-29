package dev.diplom.school.admin.controller;


import dev.diplom.school.admin.service.AdminCourseService;
import dev.diplom.school.course.exeption.CourseExeption;
import dev.diplom.school.course.model.dto.CourseRequest;
import dev.diplom.school.course.model.dto.CourseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.StringToClassMapItem;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("api/v1/admin/course")
public class AdminCourseController {

    private final AdminCourseService adminCourseService;

    public AdminCourseController(AdminCourseService adminCourseService) {
        this.adminCourseService = adminCourseService;
    }

    @PostMapping("/")
    @Operation(
            security = @SecurityRequirement(name = "keycloak"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    type = "object",
                                    properties = {
                                            @StringToClassMapItem(key = "name", value = String.class),
                                            @StringToClassMapItem(key = "description", value = String.class)
                                    }
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            headers = @Header(name = "Content-Type", description = "Тип данных"),
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(
                                                    type = "object",
                                                    properties = {
                                                            @StringToClassMapItem(key = "id", value = Long.class),
                                                            @StringToClassMapItem(key = "name", value = String.class),
                                                            @StringToClassMapItem(key = "description", value = String.class)
                                                    }
                                            )
                                    )
                            }
                    )
            })
    public ResponseEntity<?> saveCourse(@RequestBody CourseRequest courseRequest,
                                        UriComponentsBuilder uriComponentsBuilder) {
        CourseResponse courseResponse = adminCourseService.createCourse(courseRequest);
        return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/api/v1/admin/course/{productId}")
                        .build(Map.of("productId", courseResponse.id())))
                .body(courseResponse);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteCourseById(@RequestParam Long courseId) {
        adminCourseService.deleteCourse(courseId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler({CourseExeption.class})
    public void handleException() {
        // TODO
    }
}
