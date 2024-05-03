package dev.diplom.school.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "SHEPELEVA SCHOOL API",
                description = "API для школы", version = "1.0.0",
                contact = @Contact(
                        name = "Kristina Chemodanova",
                        email = "kris@yandex.ru"
                )
        )
)
public class OpenApiConfig {

}
