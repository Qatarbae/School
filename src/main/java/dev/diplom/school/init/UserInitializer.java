package dev.diplom.school.init;


import dev.diplom.school.authorization.dto.RegisterRequest;
import dev.diplom.school.authorization.service.AuthenticationService;
import dev.diplom.school.user.model.entity.Role;
import dev.diplom.school.user.model.entity.User;
import dev.diplom.school.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInitializer {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserInitializer(UserService userService,AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationService = authenticationService;
    }

    @Bean
    public void initAdminUser() {
        // Проверяем, существует ли уже пользователь с ролью ADMIN
        Optional<User> user = userService.findByRole(Role.ADMIN);
        if (!user.isPresent()) {
            authenticationService.register(new RegisterRequest(
                    "fullName",
                    "admin",
                    "123",
                    Role.ADMIN
            ));
        }
    }
}