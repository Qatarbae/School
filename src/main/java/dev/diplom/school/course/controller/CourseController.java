package dev.diplom.school.course.controller;

import dev.diplom.school.course.exeption.CourseExeption;
import dev.diplom.school.course.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.StringToClassMapItem;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    @Operation(
            security = @SecurityRequirement(name = "keycloak"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    type = "object",
                                    properties = {
                                            @StringToClassMapItem(key = "name", value = String.class),
                                    }
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            headers = @Header(name = "Content-Type", description = "Тип данных"),
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(
                                                    schema = @Schema(
                                                            type = "object",
                                                            properties = {
                                                                    @StringToClassMapItem(key = "id", value = Long.class),
                                                                    @StringToClassMapItem(key = "name", value = String.class),
                                                                    @StringToClassMapItem(key = "description", value = String.class)
                                                            }
                                                    )
                                            )
                                    )
                            }
                    )
            })
    public ResponseEntity<?> findAllCourses() {
        return ResponseEntity.ok().body(courseService.findAllCourses());
    }

    @PostMapping("/find-by-name")
    @Operation(
            security = @SecurityRequirement(name = "keycloak"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    type = "object",
                                    properties = {
                                            @StringToClassMapItem(key = "name", value = String.class),
                                    }
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
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
    public ResponseEntity<?> findByCourseName(@RequestParam String name) {
        return ResponseEntity.ok().body(courseService.findByName(name));
    }

    @PostMapping("/find-by-id")
    @Operation(
            security = @SecurityRequirement(name = "keycloak"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    type = "object",
                                    properties = {
                                            @StringToClassMapItem(key = "courseId", value = Long.class),
                                    }
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
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
    public ResponseEntity<?> findByICourseId(@RequestParam Long courseId) {

        return ResponseEntity.ok().body(courseService.findById(courseId));
    }

    @PostMapping("/find-all-by-name")
    @Operation(
            security = @SecurityRequirement(name = "keycloak"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    type = "object",
                                    properties = {
                                            @StringToClassMapItem(key = "name", value = String.class),
                                    }
                            )
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            headers = @Header(name = "Content-Type", description = "Тип данных"),
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(
                                                    schema = @Schema(
                                                            type = "object",
                                                            properties = {
                                                                    @StringToClassMapItem(key = "id", value = Long.class),
                                                                    @StringToClassMapItem(key = "name", value = String.class),
                                                                    @StringToClassMapItem(key = "description", value = String.class)
                                                            }
                                                    )
                                            )
                                    )
                            }
                    )
            })
    public ResponseEntity<?> findAllByCourseName(@RequestParam String name) {
        return ResponseEntity.ok().body(courseService.findAllByName(name));
    }

    @ExceptionHandler({CourseExeption.class})
    public void handleException() {
        // TODO
    }
}
