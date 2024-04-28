package dev.diplom.school.authorization.dto;


import dev.diplom.school.user.model.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank
    private String fullName;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private Role role;
}
