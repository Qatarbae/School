package dev.diplom.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SchoolApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

}
